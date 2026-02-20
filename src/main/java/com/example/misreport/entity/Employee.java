package com.example.misreport.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    private Double performanceScore;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private LocalDate joiningDate;
}