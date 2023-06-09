package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.TaskDto;
import com.example.mydiary.models.Lesson;
import com.example.mydiary.models.Student;
import com.example.mydiary.models.Task;
import com.example.mydiary.repositiries.LessonRepository;
import com.example.mydiary.repositiries.StudentRepository;
import com.example.mydiary.repositiries.TaskRepository;
import com.example.mydiary.sevices.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(TaskDto taskDto, Long studentId, Long lessonId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();

        taskRepository.save(Task.builder()
                        .commentary(taskDto.getCommentary())
                        .description(taskDto.getDescription())
                        .mark(taskDto.getMark())
                        .type(Task.Type.valueOf(taskDto.getType()))
                        .student(student)
                        .lesson(lesson)
                        .build());
    }

    @Override
    public void updateTask(TaskDto taskDto, Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setCommentary(taskDto.getCommentary());
        task.setDescription(taskDto.getDescription());
        task.setMark(taskDto.getMark());
        task.setType(Task.Type.valueOf(taskDto.getType()));
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
