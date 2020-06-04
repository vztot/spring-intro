package com.vztot.service;

import com.vztot.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUser(Long userId);
}
