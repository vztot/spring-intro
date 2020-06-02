package com.vztot;

import com.vztot.config.AppConfig;
import com.vztot.model.User;
import com.vztot.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User jack = new User("jack@gmail.com", "jack_is_the_best");
        User john = new User("john@gmail.com", "jack_is_sucker");

        userService.add(jack);
        userService.add(john);

        userService.listUsers().forEach(System.out::println);
    }
}
