package com.example.demo.exception;

public class CourseNotFoundException extends HttpNotFoundException {
    public CourseNotFoundException() {
        super("Course");
    }
}
