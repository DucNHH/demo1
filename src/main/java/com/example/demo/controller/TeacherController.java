package com.example.demo.controller;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping
    List<TeacherDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    TeacherDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    TeacherDTO newTeacher(@RequestBody TeacherDTO teacher) {
        return service.create(teacher);
    }

    @PutMapping("/{id}")
    TeacherDTO updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacher) {
        return service.update(id, teacher);
    }

    @DeleteMapping("/{id}")
    void deleteTeacher(@PathVariable Long id) {
        service.delete(id);
    }
}
