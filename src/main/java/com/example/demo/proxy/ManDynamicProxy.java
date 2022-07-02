package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ManDynamicProxy implements InvocationHandler {
    private Object object;
    public ManDynamicProxy(Object object)
    {
        this.object = object;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        method.invoke(object,args);
        System.out.println("Run time:"+(System.currentTimeMillis()-startTime));
        return null;
    }

    static animal getProxy()
    {
        return (animal) Proxy.newProxyInstance(Man.class.getClassLoader(),Man.class.getInterfaces(),new ManDynamicProxy(new Man()));
    }

    static Water getWaterProxy()
    {
        return (Water) Proxy.newProxyInstance(Ocean.class.getClassLoader(),Ocean.class.getInterfaces(),new ManDynamicProxy(new Ocean()));
    }
}
