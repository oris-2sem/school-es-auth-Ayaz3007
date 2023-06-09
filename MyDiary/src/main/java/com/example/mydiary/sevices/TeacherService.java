package com.example.mydiary.sevices;

import com.example.mydiary.dto.TeacherDto;
import com.example.mydiary.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();

    void addTeacher(TeacherDto teacherDto);

    void updateTeacher(TeacherDto teacherDto, Long teacherId);

    void deleteTeacher(Long teacherId);
}
