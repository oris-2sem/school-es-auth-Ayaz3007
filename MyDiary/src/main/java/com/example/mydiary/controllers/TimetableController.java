package com.example.mydiary.controllers;

import com.example.mydiary.dto.TimetableDto;
import com.example.mydiary.models.Timetable;
import com.example.mydiary.sevices.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping
    public ResponseEntity<List<Timetable>> getAll() {
        return ResponseEntity.ok(timetableService.getTimetableRecords());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TimetableDto timetableDto, @RequestParam("teacher-id")Long teacherId,
                                 @RequestParam("class-id")Long classId) {
        timetableService.addTimetableRecord(timetableDto, teacherId, classId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{timetable-id}")
    public ResponseEntity<?> update(TimetableDto timetableDto, @PathVariable("timetable-id") Long timetableID) {
        timetableService.updateTimetableRecord(timetableDto, timetableID);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{timetable-id}")
    public ResponseEntity<?> delete(@PathVariable("timetable-id")Long timetableId) {
        timetableService.deleteTimetableRecord(timetableId);
        return ResponseEntity.accepted().build();
    }
}
