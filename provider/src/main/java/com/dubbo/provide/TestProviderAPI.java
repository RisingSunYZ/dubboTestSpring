package com.dubbo.provide;

import com.alibaba.dubbo.config.*;
import com.dubbo.testSpring.UserService;

public class TestProviderAPI {

    public static void main(String [] args){

        try{
            UserService userService = new UserServiceImpl();

            ApplicationConfig appConfig = new ApplicationConfig();
            appConfig.setName("dubboProvider");

            RegistryConfig rConfig = new RegistryConfig();
            rConfig.setAddress("127.0.0.1:2181");
            rConfig.setProtocol("zookeeper");

            ProtocolConfig pConfig = new ProtocolConfig();
            pConfig.setName("dubbo");
            pConfig.setPort(20880);

            MonitorConfig mConfig = new MonitorConfig();
            mConfig.setProtocol("registry");

            // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
            ServiceConfig<UserService> sConfig = new ServiceConfig<UserService>();

            sConfig.setApplication(appConfig);
            sConfig.setRegistry(rConfig);// 多个注册中心可以用setRegistries()
            sConfig.setProtocol(pConfig);// 多个协议可以用setProtocols()
            sConfig.setMonitor(mConfig);

            sConfig.setInterface(UserService.class);
            sConfig.setGroup("dubbo");
            sConfig.setVersion("1.0.0");
            sConfig.setTimeout(3000);
            sConfig.setRef(userService);

            sConfig.export();

            Thread.currentThread().join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
