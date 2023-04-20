package com.example.demo.dto;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class TeacherDTO extends UserDTO {
    private List<String> courses;

    public TeacherDTO() {
    }

    public TeacherDTO(Teacher teacher) {
        super(teacher);
        this.courses = teacher.getCourses().stream().map(Course::getName).toList();
    }
}
