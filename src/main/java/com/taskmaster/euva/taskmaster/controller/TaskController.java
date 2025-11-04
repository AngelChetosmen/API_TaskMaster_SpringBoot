package com.taskmaster.euva.taskmaster.controller;

import com.taskmaster.euva.taskmaster.model.Task;
import com.taskmaster.euva.taskmaster.payload.request.TaskRequest;
import com.taskmaster.euva.taskmaster.security.services.TaskService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks") // 
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Obtener tareas. USER solo ve las suyas, ADMIN ve todas. 
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Task> getTasks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return taskService.getAllTasks(); // [cite: 6]
        } else {
            return taskService.getTasksByCurrentUser(); // [cite: 6]
        }
    }

    // Crear tarea. USER y ADMIN pueden crear. 
    @PostMapping // [cite: 5, 11]
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Task createTask(@Valid @RequestBody TaskRequest taskRequest) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return taskService.createTask(taskRequest, username);
    }

    // Actualizar tarea. [cite: 7, 11]
    // ADMIN puede actualizar cualquiera. USER solo las suyas.
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest taskRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Task updatedTask;

        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            updatedTask = taskService.updateTask(id, taskRequest); // 
        } else {
            updatedTask = taskService.updateMyTask(id, taskRequest, username); // 
        }
        return ResponseEntity.ok(updatedTask);
    }

    // Eliminar tarea. Solo ADMIN. [cite: 8, 11, 20]
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    
    // (Opcional) Get Tarea por ID 
    // Se deja como ejercicio (similar a updateTask, debe verificar permisos)
}