package com.example.dubbodo.httpclient;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

public interface MyClient {

    @Get("http://{serviceName}:{port}/hello/say?msg={msg}")
    String say(@Var("serviceName") String serviceName,@Var("port") String port, @Var("msg") String msg);

}
