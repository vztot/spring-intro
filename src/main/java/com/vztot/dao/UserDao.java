package com.vztot.dao;

import com.vztot.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
