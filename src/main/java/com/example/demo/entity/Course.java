package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private User teacher;
}
