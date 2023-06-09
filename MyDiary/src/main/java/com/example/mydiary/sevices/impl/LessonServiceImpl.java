package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.LessonDto;
import com.example.mydiary.models.Lesson;
import com.example.mydiary.models.Timetable;
import com.example.mydiary.repositiries.LessonRepository;
import com.example.mydiary.repositiries.TimetableRepository;
import com.example.mydiary.sevices.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final TimetableRepository timetableRepository;

    @Override
    public List<Lesson> getLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public void addLesson(LessonDto lessonDto, Long timetableId) {
        Timetable timetable = timetableRepository.findById(timetableId).orElseThrow();
        lessonRepository.save(Lesson.builder()
                        .subject(lessonDto.getSubject())
                        .theme(lessonDto.getTheme())
                        .timetable(timetable)
                        .build());
    }

    @Override
    public void updateLesson(LessonDto classDto, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();
        lesson.setSubject(classDto.getSubject());
        lesson.setTheme(classDto.getTheme());
        lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
