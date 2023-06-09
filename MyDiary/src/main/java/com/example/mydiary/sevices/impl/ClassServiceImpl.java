package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.ClassDto;
import com.example.mydiary.models.Class;
import com.example.mydiary.models.Teacher;
import com.example.mydiary.repositiries.ClassRepository;
import com.example.mydiary.repositiries.TeacherRepository;
import com.example.mydiary.sevices.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    @Override
    public void addClass(ClassDto classDto, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();
        classRepository.save(Class.builder()
                        .letter(classDto.getLetter())
                        .admissionDate(classDto.getAdmissionDate())
                        .teacher(teacher)
                        .build());
    }

    @Override
    public void updateClass(ClassDto classDto, Long classId) {
        Class schoolClass = classRepository.findById(classId).orElseThrow();
        schoolClass.setLetter(classDto.getLetter());
        schoolClass.setAdmissionDate(classDto.getAdmissionDate());
        classRepository.save(schoolClass);
    }

    @Override
    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }
}
