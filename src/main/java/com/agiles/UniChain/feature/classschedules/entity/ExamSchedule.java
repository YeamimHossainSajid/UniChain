package com.agiles.UniChain.feature.classschedules.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_schedule")
public class ExamSchedule extends BaseEntity {

    private LocalDate date;
    private LocalTime time;
    private String location;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}

