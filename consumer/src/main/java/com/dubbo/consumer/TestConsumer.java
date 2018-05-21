package com.dubbo.consumer;

import com.dubbo.testSpring.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsumer {
    public static void main(String [] args){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        UserService api = (UserService)app.getBean("userService");
        api.sayHello("yangzhao");
    }
}
