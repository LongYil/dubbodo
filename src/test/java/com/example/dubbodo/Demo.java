package com.example.dubbodo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.Properties;

/**
 * @author liyinlong
 * @since 2024/3/27 1:51 下午
 */
public class Demo {

    public static void main(String[] args) {
        try {
//            String dataId = "1399071a-cf87-4066-b632-59e974f2e0cf";
//            String group = "DEFAULT_GROUP";
//            Properties properties = new Properties();
//            properties.put("serverAddr", "10.10.101.246:32576");
//            ConfigService configService = NacosFactory.createConfigService(properties);
//
//            String content = configService.getConfig(dataId, group, 5000);
//            System.out.println(content);
            Properties properties = new Properties();
            properties.put("serverAddr", "10.10.101.246:32576");
            properties.put("username", "test");
            properties.put("password", "test");
            NamingService namingService = NacosFactory.createNamingService(properties);
            String serverStatus = namingService.getServerStatus();
            System.out.println(serverStatus);
            Instance instance = new Instance();
            instance.setInstanceId("welcome");
            instance.setServiceName("sayhello");
            instance.setIp("10.10.101.140");
            namingService.registerInstance("user", instance);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
