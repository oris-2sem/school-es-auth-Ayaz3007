package com.example.mydiary.repositiries;

import com.example.mydiary.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
