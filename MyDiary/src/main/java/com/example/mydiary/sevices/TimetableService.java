package com.example.mydiary.sevices;

import com.example.mydiary.dto.TimetableDto;
import com.example.mydiary.models.Timetable;

import java.util.List;

public interface TimetableService {
    List<Timetable> getTimetableRecords();

    void addTimetableRecord(TimetableDto timetableDto, Long teacherId, Long classId);

    void updateTimetableRecord(TimetableDto timetableDto, Long timetableId);

    void deleteTimetableRecord(Long timetableId);
}
