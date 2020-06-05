package com.vztot.controller;

import com.vztot.dto.UserResponseDto;
import com.vztot.model.User;
import com.vztot.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void inject() {
        userService.add(new User("jack@gmail.com", "john_is_sucker"));
        userService.add(new User("john@gmail.com", "jack_is_sucker"));
        userService.add(new User("mary@gmail.com", "love_jack"));
        userService.add(new User("amily@gmail.com", "love_john"));
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::buildUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return buildUserDto(userService.getUserById(userId));
    }

    private UserResponseDto buildUserDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
