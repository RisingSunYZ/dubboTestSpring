package com.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbo.testSpring.UserService;

public class TestConsumerAPI {

    public static void main(String [] args){

        try{
            ApplicationConfig aConfig = new ApplicationConfig();
            aConfig.setName("dubboConsumer");

            RegistryConfig rConfig = new RegistryConfig();
            rConfig.setProtocol("zookeeper");
            rConfig.setAddress("127.0.0.1:2181");

            MonitorConfig mConfig  = new MonitorConfig();
            mConfig.setProtocol("registry");

            // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
            ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<UserService>();
            referenceConfig.setInterface(UserService.class);
            referenceConfig.setGroup("dubbo");
            referenceConfig.setVersion("1.0.0");
            referenceConfig.setTimeout(3000);
            referenceConfig.setInjvm(false);

            referenceConfig.setApplication(aConfig);
            referenceConfig.setRegistry(rConfig); // 多个注册中心可以用setRegistries()
            referenceConfig.setMonitor(mConfig);


            UserService userService = referenceConfig.get();
            System.out.println(userService.sayHello("yangzhaoApi"));

            Thread.currentThread().join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
