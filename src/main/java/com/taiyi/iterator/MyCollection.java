package com.taiyi.iterator;

public interface MyCollection<E> {
    int size();

    boolean add(E e);

    MyIterator myIterator();
}
