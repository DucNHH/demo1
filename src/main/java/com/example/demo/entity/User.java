package com.example.demo.entity;

import com.example.demo.other.UserType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private UserType type;
    private String name;
    private Integer age;

    public User() {
    }
}


