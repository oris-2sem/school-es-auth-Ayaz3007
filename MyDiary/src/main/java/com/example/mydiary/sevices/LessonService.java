package com.example.mydiary.sevices;

import com.example.mydiary.dto.LessonDto;
import com.example.mydiary.models.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getLessons();

    void addLesson(LessonDto lessonDto, Long timetableId);

    void updateLesson(LessonDto classDto, Long lessonId);

    void deleteLesson(Long lessonId);
}
