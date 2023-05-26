package com.taiyi.iterator;

public class MyLinkedList<E> implements MyCollection<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E o) {
        Node<E> n = new Node(o);
        n.next = null;

        // 如果列表为空
        if (head == null) {
            head = n;
            tail = n;
            size++;
            return true;
        }
        tail.next = n;
        tail = n;
        size++;
        return true;
    }

    @Override
    public MyIterator myIterator() {
        return new Itr();
    }


    private class Node<E> {
        private E o;
        Node<E> next;

        public Node(E o) {
            this.o = o;
        }
    }

    private class Itr implements MyIterator<E> {

        private Node<E> currentNode = head;

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            E o;
            if (currentIndex == 0) {
                o = head.o;
            } else {
                o = currentNode.o;
            }
            currentNode = currentNode.next;
            currentIndex++;
            return o;
        }

    }
}
