package com.example.dubbodo.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(group = "userservice")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello7(String name) {
        return "Hello, " + name;
    }
}
