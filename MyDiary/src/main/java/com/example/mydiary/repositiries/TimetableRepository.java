package com.example.mydiary.repositiries;

import com.example.mydiary.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
