package com.example.mydiary.repositiries;

import com.example.mydiary.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
