package com.vztot.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@ComponentScan(basePackages = {"com.vztot.controller"})
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello.jsp";
    }
}
