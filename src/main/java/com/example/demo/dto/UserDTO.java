package com.example.demo.dto;

import com.example.demo.entity.User;
import com.example.demo.other.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private UserType type;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.type = user.getType();
    }
}
