package com.example.demo.exception;

public class TeacherNotFoundException extends HttpNotFoundException {
    public TeacherNotFoundException() {
        super("Teacher");
    }
}
