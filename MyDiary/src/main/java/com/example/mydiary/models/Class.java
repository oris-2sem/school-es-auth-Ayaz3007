package com.example.mydiary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String letter;

    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
