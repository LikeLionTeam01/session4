package com.springboot.s4.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "Subject")
    @ToString.Exclude
    @JoinColumn(name="id")
    private Subject subject;
}
