package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO login(UserDTO user) {
        return new UserDTO(repository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).orElseGet(User::new));
    }
}
