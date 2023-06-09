package com.example.mydiary.sevices;

import com.example.mydiary.dto.TaskDto;
import com.example.mydiary.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(TaskDto taskDto, Long studentId, Long lessonId);

    void updateTask(TaskDto classDto, Long taskId);

    void deleteTask(Long taskId);
}
