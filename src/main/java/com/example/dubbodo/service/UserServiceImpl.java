package com.example.dubbodo.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
