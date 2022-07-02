package com.example.demo.purejava;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1234");
        System.out.println(bigInteger.intValueExact());
    }
}
