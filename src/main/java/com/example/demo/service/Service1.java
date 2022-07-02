package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    @Scheduled(cron = "* * * * * ?")
    public void test1()
    {
        System.out.println("定时任务被执行");
    }
}
