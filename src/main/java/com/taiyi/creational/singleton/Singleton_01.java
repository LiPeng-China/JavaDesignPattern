package com.taiyi.creational.singleton;

/**
 * 饿汉式（静态常量）【可用】
 * 优点：类装在的时候完成实例化，避免了线程同步问题；
 * 缺点：如果没有使用到这个实例，就相当于是内存浪费。
 */

public class Singleton_01 {
    private final static Singleton_01 INSTANCE = new Singleton_01();

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        return INSTANCE;
    }
}

class Main_01 {
    public static void main(String[] args) {
        Singleton_01 instance_01 = Singleton_01.getInstance();
        Singleton_01 instance_02 = Singleton_01.getInstance();
        System.out.println(instance_01 == instance_02);
    }
}
