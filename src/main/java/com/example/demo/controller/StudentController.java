package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    List<StudentDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<StudentDTO> getOne(@PathVariable Long id) {
        StudentDTO dto = service.getOne(id);
        if (dto.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    StudentDTO newStudent(@RequestBody StudentDTO newStudent) {
        return service.create(newStudent);
    }

    @PutMapping("/{id}")
    StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO newStudent) {
        return service.update(id, newStudent);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{studentId}/register")
    StudentDTO registerCourse(@PathVariable Long studentId, @RequestBody CourseDTO course) {
        return service.registerCourse(studentId, course);
    }
}
