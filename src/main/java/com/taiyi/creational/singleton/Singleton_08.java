package com.taiyi.creational.singleton;

/**
 * 枚举【推荐用法】
 * 优点：解决多线程同步问题，还能防止反序列化重新创建新的对象
 */
public enum Singleton_08 {
    INSTANCE;
}

class Main_08 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_08.INSTANCE.hashCode());
            }).start();
        }
    }
}
