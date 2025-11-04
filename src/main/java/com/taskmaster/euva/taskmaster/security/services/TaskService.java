package com.taskmaster.euva.taskmaster.security.services;

import com.taskmaster.euva.taskmaster.model.Task;
import com.taskmaster.euva.taskmaster.payload.request.TaskRequest;
import java.util.List;

public interface TaskService {
    // ADMIN
    List<Task> getAllTasks(); 
    
    // USER y ADMIN
    List<Task> getTasksByCurrentUser();
    Task createTask(TaskRequest taskRequest, String username);

    // ADMIN
    Task updateTask(Long id, TaskRequest taskRequest);
    void deleteTask(Long id);

    // USER (Solo puede actualizar sus propias tareas)
    Task updateMyTask(Long id, TaskRequest taskRequest, String username);
}