package com.example.mydiary.controllers;

import com.example.mydiary.dto.LessonDto;
import com.example.mydiary.models.Lesson;
import com.example.mydiary.sevices.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<List<Lesson>> getAll() {
        return ResponseEntity.ok(lessonService.getLessons());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody LessonDto lessonDto, @RequestParam("timetable-id")Long timetableId) {
        lessonService.addLesson(lessonDto, timetableId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{lesson-id}")
    public ResponseEntity<?> update(LessonDto lessonDto, @PathVariable("lesson-id") Long lessonId) {
        lessonService.updateLesson(lessonDto, lessonId);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{lesson-id}")
    public ResponseEntity<?> delete(@PathVariable("lesson-id") Long lessonId) {
        lessonService.deleteLesson(lessonId);
        return ResponseEntity.accepted().build();
    }
}
