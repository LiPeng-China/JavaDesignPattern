package com.taiyi.creational.singleton;

import java.util.Objects;

/**
 * 懒汉式（线程不安全）【不可用】
 * 优点：按需加载实例
 * 缺点：线程不安全
 */
public class Singleton_03 {
    private static Singleton_03 instance;

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Singleton_03();
        }
        return instance;
    }
}

class Main_03 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_03.getInstance().hashCode());
            }).start();
        }
    }
}
