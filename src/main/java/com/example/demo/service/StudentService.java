package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private CourseService courseService;

    Student get(Long id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public StudentDTO getOne(Long id) {
        return new StudentDTO(get(id));
    }

    public List<StudentDTO> getAll() {
        return repository.findAll().stream().map(StudentDTO::new).toList();
    }

    public StudentDTO create(StudentDTO newStudent) {
        Student student = Student.builder()
                .name(newStudent.getName())
                .age(newStudent.getAge())
                .username(newStudent.getUsername())
                .password(newStudent.getPassword())
                .courses(new ArrayList<>())
                .build();
        return new StudentDTO(repository.save(student));
    }

    public StudentDTO update(Long id, StudentDTO newStudent) {
        newStudent.setId(repository.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            student.setPassword(newStudent.getPassword());
            return repository.save(student);
        }).orElseThrow(StudentNotFoundException::new).getId());
        newStudent.setPassword(null);
        return newStudent;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public StudentDTO registerCourse(Long studentId, CourseDTO courseDTO) {
        Student student = get(studentId);
        Course course = courseService.get(courseDTO.getId());
        student.getCourses().add(course);
        courseService.register(course, student);
        return new StudentDTO(repository.save(student));
    }
}
