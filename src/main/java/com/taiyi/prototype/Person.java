package com.taiyi.prototype;

public class Person implements Cloneable{
    int age = 8;
    int score = 100;
    Location loc = new Location(new String("bj"), 22);

    /**
     * 描述：
     *      浅克隆：如果一个类在内存中已经存在，Object.clone() 会将这份内存再 copy 一份出来
     * @return
     * @throws CloneNotSupportedException
     */
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    /**
     * 描述：
     *      深克隆：引用类型也做 clone 处理
     *      String 也是引用率类型，需要进行深克隆吗
     *      A：不需要，String 类型指向常量池。但 new 出来的 String 对象是浅 copy
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) p.loc.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}
