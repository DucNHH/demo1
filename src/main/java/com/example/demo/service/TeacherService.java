package com.example.demo.service;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.TeacherNotFoundException;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    Teacher get(Long id) {
        return repository.findById(id).orElseThrow(TeacherNotFoundException::new);
    }

    public TeacherDTO getOne(Long id) {
        return new TeacherDTO(get(id));
    }

    public List<TeacherDTO> getAll() {
        return repository.findAll().stream().map(TeacherDTO::new).toList();
    }

    public TeacherDTO create(TeacherDTO newTeacher) {
        Teacher teacher = Teacher.builder()
                .name(newTeacher.getName())
                .age(newTeacher.getAge())
                .username(newTeacher.getUsername())
                .password(newTeacher.getPassword())
                .build();
        return new TeacherDTO(repository.save(teacher));
    }

    public TeacherDTO update(Long id, TeacherDTO newTeacher) {
        newTeacher.setId(repository.findById(id).map(teacher -> {
                    teacher.setName(newTeacher.getName());
                    teacher.setAge(newTeacher.getAge());
                    teacher.setPassword(newTeacher.getPassword());
                    return repository.save(teacher);
                })
                .orElseThrow(TeacherNotFoundException::new).getId());
        newTeacher.setPassword(null);
        return newTeacher;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void teach(Teacher teacher, Course course) {
        teacher.getCourses().add(course);
        repository.save(teacher);
    }
}
