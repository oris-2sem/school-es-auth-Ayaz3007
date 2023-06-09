package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.StudentDto;
import com.example.mydiary.models.Class;
import com.example.mydiary.models.Parent;
import com.example.mydiary.models.Student;
import com.example.mydiary.repositiries.ClassRepository;
import com.example.mydiary.repositiries.ParentRepository;
import com.example.mydiary.repositiries.StudentRepository;
import com.example.mydiary.sevices.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final ParentRepository parentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(StudentDto studentDto, Long parentId, Long classId) {
        Parent parent = parentRepository.findById(parentId).orElseThrow();
        Class schoolClass = classRepository.findById(classId).orElseThrow();
        studentRepository.save(Student.builder()
                        .firstName(studentDto.getFirstName())
                        .lastName(studentDto.getLastName())
                        .parent(parent)
                        .schoolClass(schoolClass)
                        .build());
    }

    @Override
    public void updateStudent(StudentDto studentDto, Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
