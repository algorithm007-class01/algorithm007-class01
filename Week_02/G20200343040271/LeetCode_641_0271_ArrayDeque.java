package com.algorithm.homework;

import java.util.Arrays;

/**
 * 数组实现，头尾指针，增删时间复杂度：O(n)，查询复杂度：O(1)
 */
public class MyArrayDeque {

    private Object[] queue;

    private int capacity;

    private int size;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyArrayDeque(int k) {
        this.capacity = k;
        queue = new Object[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if(isFull()){
            return false;
        }

        if(isEmpty()){
            queue[0] = value;
        }else{
            Object[] newQueue = new Object[capacity];
            System.arraycopy(queue,0, newQueue,1,size);
            newQueue[0] = value;
            queue = newQueue;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        queue[size++] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        Object[] newQueue = new Object[capacity];
        System.arraycopy(queue,1, newQueue, 0, --size);
        queue = newQueue;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        queue[--size] = null;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return (Integer) queue[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return (Integer) queue[size-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
