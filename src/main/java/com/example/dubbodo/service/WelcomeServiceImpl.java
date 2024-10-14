package com.example.dubbodo.service;

import org.springframework.stereotype.Service;

/**
 * @author liyinlong
 * @since 2024/7/18 3:03 下午 com.example.dubbodo.service.WelcomeServiceImpl
 */
@Service
public class WelcomeServiceImpl implements WelcomeService{


    @Override
    public String test(String msg) {
        System.out.println("收到信息"+msg);
        return msg + ":" + System.currentTimeMillis();
    }

}
