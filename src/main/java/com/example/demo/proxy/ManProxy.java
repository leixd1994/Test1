package com.example.demo.proxy;

public class ManProxy implements animal{
    private animal a;
    public ManProxy(animal a)
    {
        this.a=a;
    }
    @Override
    public void say() {
        long startTime = System.currentTimeMillis();
        a.say();
        System.out.println("Run time:"+(System.currentTimeMillis()-startTime));
    }
}
