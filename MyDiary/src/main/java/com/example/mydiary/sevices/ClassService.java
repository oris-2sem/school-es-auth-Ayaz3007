package com.example.mydiary.sevices;

import com.example.mydiary.dto.ClassDto;
import com.example.mydiary.models.Class;

import java.util.List;

public interface ClassService {
    List<Class> getClasses();

    void addClass(ClassDto classDto, Long teacherId);

    void updateClass(ClassDto classDto, Long classId);

    void deleteClass(Long classId);
}
