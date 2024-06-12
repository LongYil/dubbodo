package com.example.dubbodo.controller;

import com.example.dubbodo.httpclient.MyClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author liyinlong
 * @since 2024/4/7 6:35 下午
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private MyClient myClient;

    private String port = "9090";

    private static Integer errorCount = 5;

    @GetMapping("/say")
    public String say(HttpServletRequest request,
                      @RequestParam String msg,
                      @RequestParam(required = false, defaultValue = "1") Integer wait,
                      @RequestParam(required = false, defaultValue = "1") Integer errorNum,
                      @RequestParam(required = false, defaultValue = "") String injectError) {
        log.info("收到请求:msg={}", msg);
        if (!StringUtils.isNotEmpty(injectError)) {
            injectError = System.getenv().get("INJECT_ERROR");
        }
        if ("true".equalsIgnoreCase(injectError)) {
            if (errorCount > 0) {
                errorCount--;
                Integer.parseInt("true");
            }
        }
        errorCount = 5;
        log.info("收到请求信息：{}，等待{}秒", msg, wait);
        try {
            for (int i = 0; i < wait; i++) {
                log.info("已等待:{}秒", i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        String providerService = System.getenv().get("PROVIDER_SERVICE");
        msg = msg + ",Handled by " + appName + "-" + System.getenv().get("POD_NAME") + "\n";
        if (StringUtils.isEmpty(providerService)) {
            log.info("本次请求结果为：{}", msg);
            return msg;
        }
        log.info("请求远端服务:{}", providerService);
        try {
            msg = myClient.say(providerService, port, msg, errorNum);
        } catch (Exception e) {
            log.info("请求服务{}出错了", providerService, e);
        }
        log.info("请求服务{}的返回结果为:{}", providerService, msg);
        return msg;
    }

}
