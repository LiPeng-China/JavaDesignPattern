package com.taiyi.creational.singleton;

import java.util.Objects;

/**
 * 懒汉式（线程同步方法）【不推荐用】
 * 优点：线程安全
 * 缺点：同步效率太低，后续的线程不需要进入if，会直接返回，但仍然会被同步限制
 */
public class Singleton_04 {
    private static Singleton_04 instance;

    private Singleton_04() {
    }

    public static synchronized Singleton_04 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Singleton_04();
        }
        return instance;
    }
}

class Main_04 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_04.getInstance().hashCode());
            }).start();
        }
    }
}
