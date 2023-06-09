package com.example.mydiary.sevices.impl;

import com.example.mydiary.dto.TimetableDto;
import com.example.mydiary.models.Class;
import com.example.mydiary.models.Teacher;
import com.example.mydiary.models.Timetable;
import com.example.mydiary.repositiries.ClassRepository;
import com.example.mydiary.repositiries.TeacherRepository;
import com.example.mydiary.repositiries.TimetableRepository;
import com.example.mydiary.sevices.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public List<Timetable> getTimetableRecords() {
        return timetableRepository.findAll();
    }

    @Override
    public void addTimetableRecord(TimetableDto newTimetableDto, Long teacherId, Long classId) {
        Class schoolClass = classRepository.findById(classId).orElseThrow();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();

        timetableRepository.save(Timetable.builder()
                        .dateTime(newTimetableDto.getDateTime())
                        .roomNumber(newTimetableDto.getRoomNumber())
                        .teacher(teacher)
                        .schoolClass(schoolClass)
                        .build());
    }

    @Override
    public void updateTimetableRecord(TimetableDto timetableDto, Long timetableId) {
        Timetable timetable = timetableRepository.findById(timetableId).orElseThrow();
        timetable.setRoomNumber(timetableDto.getRoomNumber());
        timetable.setDateTime(timetableDto.getDateTime());
        timetableRepository.save(timetable);
    }

    @Override
    public void deleteTimetableRecord(Long timetableId) {
        timetableRepository.deleteById(timetableId);
    }
}
