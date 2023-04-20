package com.example.demo.exception;

public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException(String obj) {
        super(obj + " not found");
    }
}
