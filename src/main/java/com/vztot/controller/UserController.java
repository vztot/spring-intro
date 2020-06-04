package com.vztot.controller;

import com.vztot.UserResponseDto;
import com.vztot.dao.UserDao;
import com.vztot.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/inject")
    public void inject() {
        userDao.add(new User("jack@gmail.com", "john_is_sucker"));
        userDao.add(new User("john@gmail.com", "jack_is_sucker"));
        userDao.add(new User("mary@gmail.com", "love_jack"));
        userDao.add(new User("amily@gmail.com", "love_john"));
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userDao.listUsers().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public UserResponseDto get(@PathVariable Long userId) {
        return new UserResponseDto(userDao.getUser(userId));
    }
}
