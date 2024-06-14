package com.example.dubbodo.providerservice;

import com.example.dubbodo.common.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

@DubboService
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello(String name) {
        String bizId = RpcContext.getServerAttachment().getAttachment("bizId");
        System.out.println("用户服务,流水号" + bizId);
        return "UserService say:Hello, " + name;
    }

}
