package com.example.dubbodo;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ForestScan(basePackages = "com.example.dubbodo.httpclient")
@SpringBootApplication
public class DubbodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbodoApplication.class, args);

    }

}
