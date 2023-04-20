package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        UserDTO dto = service.login(userDTO);
        if (dto.getId() == null) {
            return ResponseEntity.badRequest().body("Login failed");
        }
        return ResponseEntity.ok(dto);
    }
}
