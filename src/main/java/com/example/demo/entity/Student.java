package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@DiscriminatorValue("student")
@SuperBuilder
public class Student extends User {

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }
}
