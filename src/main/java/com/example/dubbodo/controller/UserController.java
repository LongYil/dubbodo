package com.example.dubbodo.controller;

import com.example.dubbodo.service.UserService;
import com.example.dubbodo.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyinlong
 * @since 2024/7/18 3:01 下午 com.example.dubbodo.controller.UserController.java
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private WelcomeService welcomeService;

    @GetMapping("/test")
    public String test(@RequestParam String msg){
        return welcomeService.test(msg);
    }

    @GetMapping("/hello")
    public String hello(){
        return welcomeService.test("hello");
    }

}
