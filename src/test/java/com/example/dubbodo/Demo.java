package com.example.dubbodo;

//import com.alibaba.nacos.api.NacosFactory;
//import com.alibaba.nacos.api.config.ConfigService;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author liyinlong
 * @since 2024/3/27 1:51 下午
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i=0;i<10;i++){
            list.add(String.valueOf(i));
        }

        list.stream().parallel().forEach(item ->{
            System.out.println("开始任务:" + item);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("结束任务:" + item);
        });

    }
}
