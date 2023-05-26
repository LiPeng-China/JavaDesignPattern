package com.taiyi.iterator;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyCollection<String> list = new MyLinkedList<>();

        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());

        MyIterator<String> itr = list.myIterator();
        while (itr.hasNext()) {
            String o = itr.next();
            System.out.println(o);
        }
    }
}
