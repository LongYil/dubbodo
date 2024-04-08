package com.example.dubbodo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpHeaders;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author liyinlong
 * @since 2024/4/7 6:35 下午
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/say")
    public String say(HttpServletRequest request, @RequestParam String msg) {
        log.info("收到请求信息：{}", msg);
        log.info("=====================开始打印header=====================");
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = request.getHeader(key);
                log.info("key:{} ---> values:{}", key, value);
            }
        }
        log.info("=====================header打印完毕=====================");
        return msg;
    }

}
