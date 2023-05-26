package com.taiyi.flyweight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyInteger i = MyInteger.valueOf(12);
        MyInteger j = MyInteger.valueOf(12);
        System.out.println(i == j);

        MyInteger m = MyInteger.valueOf(128);
        MyInteger n = MyInteger.valueOf(128);
        System.out.println(m == n);
    }
}