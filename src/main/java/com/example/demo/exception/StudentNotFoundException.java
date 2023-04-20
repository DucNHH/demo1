package com.example.demo.exception;

public class StudentNotFoundException extends HttpNotFoundException {
    public StudentNotFoundException() {
        super("Student");
    }
}
