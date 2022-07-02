package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Student {
    @Resource
    private AnotherCat cat2;
    @Resource
    private Dog dog2;

    @Override
    public String toString() {
        return "Student{" +
                "cat=" + cat2 +
                ", dog=" + dog2 +
                '}';
    }
}
