package com.example.demo.dto;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String courseName;
    private Long teacherId;
    private List<Long> students;

    public CourseDTO() {
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.courseName = course.getName();
        this.teacherId = course.getTeacher().getId();
        this.students = course.getStudents().stream().map(Student::getId).toList();
    }
}
