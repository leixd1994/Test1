package com.example.demo.proxy;

public class Main {
    public static void main(String[] args) {
        //animal a = new ManProxy(new Man());
        animal a = ManDynamicProxy.getProxy();
        System.out.println(a.getClass());
        a.say();
        Water waterProxy = ManDynamicProxy.getWaterProxy();
        System.out.println(waterProxy.getClass());
        waterProxy.describe();

    }
}
