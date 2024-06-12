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

/**
 * @author liyinlong
 * @since 2024/3/27 1:51 下午
 */
public class Demo {

    public static void main(String[] args) {
        List<Integer>  ports = new ArrayList<>();
        ports.add(1);
        ports.add(2);
        ports.add(3);

        System.out.println(Arrays.toString(ports.toArray()));
    }
}
