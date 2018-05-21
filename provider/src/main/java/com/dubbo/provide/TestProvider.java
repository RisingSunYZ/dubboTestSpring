package com.dubbo.provide;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProvider {
    public static void main(String [] args){
        try{
            ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:provider.xml");
            System.out.println(11);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
