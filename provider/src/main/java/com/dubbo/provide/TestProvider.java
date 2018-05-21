package com.dubbo.provide;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class TestProvider {
    public static void main(String [] args){
        try{
            ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:provider.xml");
            Thread.currentThread().join();
//            Thread.currentThread().start();
//            CountDownLatch countDownLatch=new CountDownLatch(1);
//            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
