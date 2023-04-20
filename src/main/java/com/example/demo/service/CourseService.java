package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.CourseNotFoundException;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private TeacherService teacherService;

    Course get(Long id) {
        return repository.findById(id).orElseThrow(CourseNotFoundException::new);
    }

    public CourseDTO getOne(Long id) {
        return new CourseDTO(get(id));
    }

    public List<CourseDTO> getAll() {
        return repository.findAll().stream().map(CourseDTO::new).toList();
    }

    public CourseDTO create(CourseDTO newCourse) {
        Course course = new Course();
        course.setName(newCourse.getCourseName());
        Teacher teacher = teacherService.get(newCourse.getTeacherId());
        course.setTeacher(teacher);
        teacherService.teach(teacher, course);
        return new CourseDTO(repository.save(course));
    }

    public CourseDTO update(Long id, CourseDTO newCourse) {
        return new CourseDTO(repository.findById(id).map(course -> {
                    course.setName(newCourse.getCourseName());
                    course.setTeacher(teacherService.get(newCourse.getTeacherId()));
                    return repository.save(course);
                })
                .orElseThrow(CourseNotFoundException::new));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void register(Course course, Student student) {
        course.getStudents().add(student);
        repository.save(course);
    }
}
