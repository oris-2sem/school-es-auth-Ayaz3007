package com.example.mydiary.controllers;

import com.example.mydiary.dto.TeacherDto;
import com.example.mydiary.models.Teacher;
import com.example.mydiary.sevices.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TeacherDto teacherDto) {
        teacherService.addTeacher(teacherDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{teacher-id}")
    public ResponseEntity<?> update(TeacherDto teacherDto, @PathVariable("teacher-id")Long teacherId) {
        teacherService.updateTeacher(teacherDto, teacherId);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{teacher-id}")
    public ResponseEntity<?> delete(@PathVariable("teacher-id")Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.accepted().build();
    }
}
