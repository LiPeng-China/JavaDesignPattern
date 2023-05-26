package com.taiyi.creational.singleton;

/**
 * 饿汉式（静态代码块）【可用】
 * 优缺点：同上
 */

public class Singleton_02 {
    private static Singleton_02 instance;

    static {
        instance = new Singleton_02();
    }

    private Singleton_02() {
    }

    public static Singleton_02 getInstance() {
        return instance;
    }
}

class Main_02 {
    public static void main(String[] args) {
        Singleton_01 instance_01 = Singleton_01.getInstance();
        Singleton_01 instance_02 = Singleton_01.getInstance();
        System.out.println(instance_01 == instance_02);
    }
}