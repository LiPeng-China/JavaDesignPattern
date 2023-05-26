package com.taiyi.creational.singleton;

/**
 * 静态内部类【推荐使用】
 * 优点：实现懒加载，JVM保证单例，保证线程安全：加载外部类时不会加载内部类，类的初始化是线程安全的。
 * 线程安全、延迟加载、效率高
 */
public class Singleton_07 {
    private Singleton_07() {
    }

    private static class SingletonClass {
        public static final Singleton_07 INSTANCE = new Singleton_07();
    }

    public static Singleton_07 getInstance() {
        return SingletonClass.INSTANCE;
    }
}

class Main_07 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_07.getInstance().hashCode());
            }).start();
        }
    }
}
