package com.dubbo.provide;

import com.dubbo.testSpring.Person;

public class PersonImpl implements Person{

    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
