package com.example.mydiary.controllers;

import com.example.mydiary.dto.StudentDto;
import com.example.mydiary.models.Student;
import com.example.mydiary.sevices.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody StudentDto studentDto, @RequestParam("parent-id")Long parentId,
                                 @RequestParam("class-id")Long classId) {
        studentService.addStudent(studentDto, parentId, classId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<?> update(StudentDto studentDto, @PathVariable("student-id")Long studentId) {
        studentService.updateStudent(studentDto, studentId);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<?> delete(@PathVariable("student-id")Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.accepted().build();
    }
}
