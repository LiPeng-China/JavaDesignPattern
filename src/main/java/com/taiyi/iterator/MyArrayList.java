package com.taiyi.iterator;

public class MyArrayList<E> implements MyCollection<E> {
    private int index = 0;
    E[] objects = (E[])new Object[10];

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public boolean add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[])new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
        return false;
    }

    @Override
    public MyIterator myIterator() {
        return new Itr();
    }

    private class Itr implements MyIterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E o = objects[currentIndex];
            currentIndex++;
            return o;
        }


    }
}
