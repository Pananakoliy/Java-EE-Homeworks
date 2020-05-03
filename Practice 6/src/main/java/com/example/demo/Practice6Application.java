package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice6Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Practice6Application.class, args);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.createUser("fn1","ln1");
        userService.createUser("fn1","ln12");
        userService.createUser("fn1","ln2");
        System.out.println(userService.getUsersBySubstring("ln1"));
    }

}
