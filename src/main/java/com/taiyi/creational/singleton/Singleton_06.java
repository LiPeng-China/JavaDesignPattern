package com.taiyi.creational.singleton;

import java.util.Objects;

/**
 * 双重检查（Double check）【推荐使用】
 * 优点：线程安全、延迟加载、效率较高
 * 缺点：费代码
 */
public class Singleton_06 {
    private static volatile Singleton_06 instance;

    private Singleton_06() {
    }

    public static Singleton_06 getInstance() {
        if (Objects.isNull(instance)) {      // 第一次判断：减少后续线程上锁的次数（加锁耗资源）
            synchronized (Singleton_06.class) {
                if (Objects.isNull(instance)) {      // 第二次判断：防止线程不安全
                    instance = new Singleton_06();
                }
            }
        }
        return instance;
    }
}

class Main_06 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_06.getInstance().hashCode());
            }).start();
        }
    }
}
