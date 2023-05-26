package com.taiyi.creational.singleton;

import java.util.Objects;

/**
 * 懒汉式（同步代码块）【不可用】
 * 优点：同步代码块，效率更高
 * 缺点：线程不安全，一个线程进入if，此时切换到另一个线程，也会进入到if，此时就会产生多个实例
 */
public class Singleton_05 {
    private static Singleton_05 instance;

    private Singleton_05() {
    }

    public static Singleton_05 getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Singleton_05.class) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }
}

class Main_05 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_05.getInstance().hashCode());
            }).start();
        }
    }
}