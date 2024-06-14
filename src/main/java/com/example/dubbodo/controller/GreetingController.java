package com.example.dubbodo.controller;

import com.example.dubbodo.common.GreetingService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.metadata.MetadataService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class GreetingController {

    @DubboReference
    private GreetingService greetingService;

    @GetMapping("/hello")
    private String sayHello(@RequestParam String msg) {
        long time = System.currentTimeMillis();
        RpcContext.getClientAttachment().setAttachment("bizId", String.valueOf(time));
        String res = greetingService.sayHello(msg);
        return res;
    }

}