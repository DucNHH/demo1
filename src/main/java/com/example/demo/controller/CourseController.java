package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public CourseDTO getOne(Long id) {
        return courseService.getOne(id);
    }

    @GetMapping
    public List<CourseDTO> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO courseDTO) {
        return courseService.create(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        return courseService.update(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
