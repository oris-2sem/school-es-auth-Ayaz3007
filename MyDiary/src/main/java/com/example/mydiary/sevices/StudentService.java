package com.example.mydiary.sevices;

import com.example.mydiary.dto.StudentDto;
import com.example.mydiary.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    void addStudent(StudentDto studentDto, Long parentId, Long classId);

    void updateStudent(StudentDto studentDto, Long studentId);

    void deleteStudent(Long studentId);
}
