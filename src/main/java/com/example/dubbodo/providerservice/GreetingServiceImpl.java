package com.example.dubbodo.providerservice;

import com.example.dubbodo.common.GreetingService;
import com.example.dubbodo.common.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

@DubboService
public class GreetingServiceImpl implements GreetingService {

    @DubboReference
    private UserService userService;

    @Override
    public String sayHello(String name) {
        String bizId = RpcContext.getServerAttachment().getAttachment("bizId");
        System.out.println("客服服务,流水号" + bizId);
        String res = userService.sayHello(name);
        return "GreetingService say: Hello, " + res;
    }

}
