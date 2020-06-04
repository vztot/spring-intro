package com.vztot;

import com.vztot.model.User;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String password;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
