package com.example.demo.dto;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class StudentDTO extends UserDTO {
    private List<String> courses;

    public StudentDTO() {
    }

    public StudentDTO(Student student) {
        super(student);
        this.courses = student.getCourses().stream().map(Course::getName).toList();
    }
}
