package com.agiles.UniChain.feature.classschedules.entity;

import com.agiles.UniChain.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment")
public class Assignment extends BaseEntity {

    private String title;
    private LocalDate dueDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}

