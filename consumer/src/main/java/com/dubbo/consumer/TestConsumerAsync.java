package com.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import java.util.concurrent.Future;
import com.dubbo.testSpring.UserService;

public class TestConsumerAsync {

    public static void main(String [] args){
        try{
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubboConsumer");

            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("127.0.0.1:2181");

            ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<UserService>();

            referenceConfig.setApplication(applicationConfig);
            referenceConfig.setRegistry(registryConfig);
            referenceConfig.setInterface(UserService.class);
            referenceConfig.setGroup("dubbo");
            referenceConfig.setVersion("1.0.0");
            referenceConfig.setTimeout(3000);

            referenceConfig.setAsync(true);

            UserService userService = referenceConfig.get();

            long beginTime = System.currentTimeMillis();
            System.out.println(userService.sayHello("yangzhao001"));


            Future<String> userServiceFutureOne  = RpcContext.getContext().getFuture();
            System.out.println(userServiceFutureOne.get());

            System.out.println(userService.sayHello("yangzhao002"));

            Future<String> userServiceFutureTwo  = RpcContext.getContext().getFuture();
            System.out.println(userServiceFutureTwo.get());
            long endTime = System.currentTimeMillis();

            System.out.println("cost:"+(endTime-beginTime));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
