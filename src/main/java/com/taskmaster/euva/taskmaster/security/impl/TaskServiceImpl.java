package com.taskmaster.euva.taskmaster.security.impl;

import com.taskmaster.euva.taskmaster.model.Task;
import com.taskmaster.euva.taskmaster.model.User;
import com.taskmaster.euva.taskmaster.payload.request.TaskRequest;
import com.taskmaster.euva.taskmaster.repository.TaskRepository;
import com.taskmaster.euva.taskmaster.repository.UserRepository;
import com.taskmaster.euva.taskmaster.security.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado."));
    }

    @Override
    public List<Task> getAllTasks() {
        // Lógica para ADMIN
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByCurrentUser() {
        // Lógica para USER y ADMIN
        // (Aunque para ADMIN, podríamos querer que vea todas)
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = getUserByUsername(username);
        return taskRepository.findByUserId(user.getId());
    }

    @Override
    public Task createTask(TaskRequest taskRequest, String username) {
        User user = getUserByUsername(username);
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(false);
        task.setUser(user);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, TaskRequest taskRequest) {
        // Lógica para ADMIN
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(taskRequest.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        // Lógica para ADMIN
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateMyTask(Long id, TaskRequest taskRequest, String username) {
        // Lógica para USER (verifica propiedad)
        User user = getUserByUsername(username);
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("No tienes permiso para modificar esta tarea");
        }

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(taskRequest.isCompleted());
        return taskRepository.save(task);
    }
}