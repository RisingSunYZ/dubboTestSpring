package com.dubbo.provide;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.testSpring.Person;
import com.dubbo.testSpring.UserService;

public class userServiceImpl implements UserService{
    public String sayHello(String name){
        return name;
    };

    public String sayPerson(Person person){
        return JSONObject.toJSONString(person);
    };

}
