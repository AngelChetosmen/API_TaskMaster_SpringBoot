package com.taskmaster.euva.taskmaster.repository;

import com.taskmaster.euva.taskmaster.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Busca tareas por el ID del usuario
    List<Task> findByUserId(Long userId);
}