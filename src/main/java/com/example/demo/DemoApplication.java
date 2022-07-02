package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.util.pattern.PathPattern;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@ServletComponentScan
@SpringBootApplication
@EnableScheduling
class Chicken{
    int id;
}
class Producer extends Thread{
    private SyncContainer syncContainer;

    public Producer(SyncContainer syncContainer) {
        this.syncContainer = syncContainer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <100 ; i++) {
                this.syncContainer.push(new Chicken());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread{
    private SyncContainer syncContainer;

    public Consumer(SyncContainer syncContainer) {

            this.syncContainer = syncContainer;


    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                this.syncContainer.pop();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SyncContainer{
    Chicken[] chickens=new Chicken[10];
    int count=0;
    private Producer producer;
    private Consumer consumer;

    public SyncContainer(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    synchronized void push(Chicken chicken) throws InterruptedException {
        if (count==chickens.length)
        {
            this.wait();
        }
        chickens[count]=chicken;

        count++;
        System.out.println("生产了第"+count+"只鸡");
        this.notifyAll();

    }
    synchronized void pop() throws InterruptedException{
        if (count==0)
        {
            this.wait();
        }
        System.out.println("消费了第"+count+"只鸡");
        count--;

        this.notifyAll();
    }

}

class TestCallable implements Callable<String>
{

    @Override
    public String call() throws Exception {
        return "Hello world";
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.CONSTRUCTOR,ElementType.TYPE})
@interface myAnno{

}

@myAnno
public class DemoApplication {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SpringApplication.run(DemoApplication.class, args);

    }

}
