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

        User jackJohnson = new User("jack_johnson@gmail.com", "john_is_sucker");
        User johnJackson = new User("john_jackson@gmail.com", "jack_is_sucker");

        userService.add(jackJohnson);
        userService.add(johnJackson);

        userService.listUsers().forEach(System.out::println);
    }
}
