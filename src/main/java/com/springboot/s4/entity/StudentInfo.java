package com.springboot.s4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_info")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String name;

    @OneToOne
    @JoinColumn(name = "lion_id")
    private StudentEntity studentEntity;
}
