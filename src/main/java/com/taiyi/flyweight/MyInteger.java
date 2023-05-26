package com.taiyi.flyweight;

public class MyInteger {
    private int i;

    public MyInteger(int i) {
        this.i = i;
    }


    /**
     * @param i 如果 i 在 -128 ~ 127 之间，则计算下标并从 cache 中返回，否则传建一个新的对象
     * @return
     */
    public static MyInteger valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new MyInteger(i);
    }

    /**
     * 静态内部类
     * 默认先创建并缓存 -128 ~ 127 之间数的 Integer 对象
     */
    private static class IntegerCache {
        static final int low = -128;
        static final int high = 127;
        static final MyInteger cache[];

        static {
            cache = new MyInteger[high - low + 1];
            int j = low;
            for (int k = 0; k < cache.length; k++) {
                cache[k] = new MyInteger(j++);
            }

        }

        private IntegerCache() {
        }
    }
}
