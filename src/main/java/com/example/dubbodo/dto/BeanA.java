package com.example.dubbodo.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyinlong
 * @since 2024/9/1 10:52 上午
 */
@Component
public class BeanA {

    @Autowired
    private BeanB beanB;

}
