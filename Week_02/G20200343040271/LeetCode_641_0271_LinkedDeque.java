package com.algorithm.homework;

/**
 * 链表实现，头尾指针，增删时间复杂度：O(1)，查询复杂度：O(n)
 */
public class MyLinkedDeque {

    private Node head;
    private Node tail;

    private int capacity;

    private int size;

    private int modCount;

    public MyLinkedDeque(int k) {
        this.capacity = k;
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return (Integer) head.data;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return (Integer) tail.data;
    }


    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        Node newTail = tail.prev;
        tail = newTail;
        if(newTail == null){
            head = null;
        }else {
            newTail.next = null;
        }
        size--;
        modCount++;

        return true;
    }


    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        Node newhead = head.next;
        head = newhead;
        if(newhead == null){
            tail = null;
        }else {
            newhead.prev = null;
        }
        size--;
        modCount++;

        return true;
    }



    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        Node t = tail;
        Node node = new Node(t,value, null);
        tail = node;
        if(t == null){
            head = node;
        } else {
            t.next = node;
        }
        size++;
        modCount++;

        return true;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if(isFull()){
            return false;
        }
        Node oldHeadNode = head;
        Node newNode = new Node(null, value, oldHeadNode);
        head = newNode;
        if(oldHeadNode == null){
            tail = newNode;
        }else{
            oldHeadNode.prev = newNode;
        }
        size++;
        modCount++;
        return true;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }


    private class Node{
        private Object data; // 元素
        private Node next; // 后继
        private Node prev; // 前驱

        public Node(Node prev, Object value, Node next){
            this.prev = prev;
            this.data = value;
            this.next = next;
        }
    }
}
