package com.example.dubbodo.httpclient;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

public interface MyClient {

    @Get("http://{serviceName}:{port}/hello/say?msg={msg}")
    String say(@Var("serviceName") String serviceName,@Var("port") String port, @Var("msg") String msg);

    @Get("http://localhost:8080/meshes/getServiceEntries?serviceMeshId=13fb709d-a6a0-4794-8173-00d087126a83")
    String test();

}
