package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Table
@Inheritance
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(name = "role", updatable = false, insertable = false)
    private String role;
    private String name;
    private Integer age;

    public User() {
    }
}
