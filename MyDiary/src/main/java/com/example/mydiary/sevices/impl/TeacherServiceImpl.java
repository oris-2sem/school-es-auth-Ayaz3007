package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.TeacherDto;
import com.example.mydiary.models.Teacher;
import com.example.mydiary.repositiries.TeacherRepository;
import com.example.mydiary.sevices.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void addTeacher(TeacherDto teacherDto) {
        teacherRepository.save(Teacher.builder()
                        .firstName(teacherDto.getFirstName())
                        .lastName(teacherDto.getLastName())
                        .build());
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
