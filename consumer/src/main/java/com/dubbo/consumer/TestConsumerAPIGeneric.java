package com.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.Map;
import java.util.HashMap;

public class TestConsumerAPIGeneric {

    public static void main (String [] args){

        ApplicationConfig aConfig = new ApplicationConfig();
        aConfig.setName("dubboConsumer");

        RegistryConfig rConfig = new RegistryConfig();
        rConfig.setAddress("127.0.0.1:2181");
        rConfig.setProtocol("zookeeper");

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<GenericService>();
        referenceConfig.setApplication(aConfig);
        referenceConfig.setRegistry(rConfig);
        referenceConfig.setTimeout(3000);
        referenceConfig.setGroup("dubbo");
        referenceConfig.setVersion("1.0.0");

        referenceConfig.setInterface("com.dubbo.testSpring.UserService");
        referenceConfig.setGeneric(true);

        GenericService userService = referenceConfig.get();
        Object res = userService.$invoke("sayHello",new String[]{"java.lang.String"},new Object[]{"yangzhao3"});
        System.out.println(res);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("class","com.dubbo.provide.PersonImpl");
        map.put("name","yangzhao4");
        map.put("passWord","123456");
        Object resPerson = userService.$invoke("sayPerson",new String[]{"com.dubbo.testSpring.Person"},new Object[]{map});
        System.out.println(resPerson);

    }
}
