package com.example.dubbodo.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
//@DubboService(registry = {"shanghai"})
public class ProjectServiceImpl implements ProjectService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public String sayHello2(String name) {
        return null;
    }

    @Override
    public String sayHello3(String name) {
        return null;
    }


}
