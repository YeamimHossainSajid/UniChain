package com.agiles.UniChain.feature.classschedules.entity;
import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "class_schedule")
public class ClassSchedule extends BaseEntity {

    private String day;
    private LocalTime time;
    private String location;
    private LocalTime reminderTime;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}

