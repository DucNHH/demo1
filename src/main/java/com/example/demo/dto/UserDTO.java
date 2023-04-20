package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String role;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.role = user.getRole();
    }
}
