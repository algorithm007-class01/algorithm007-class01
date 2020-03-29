package com.algorithm.homework;

/**
 * 数组实现，头尾指针，循环数组填充数据，头指针始终指向队首，尾指针始终指向队尾(最后 1 个有效数据)下一个元素
 * 队首新增元素，头指针左移，-1，队首出元素，头指针右移 +1
 * 队尾新增元素，尾指针右移，+1，队尾出元素，头指针左移 -1
 * 为了避免当元素在数组0左移-1后，出现负数，为了求出正确的位置，(指针位置 -1 + capacity)%capacity 取模操作
 * 增删时间复杂度：O(1)，查询复杂度：O(n)
 */
public class MyArrayCircularDeque {
    private Object[] queue;
    // 容量
    private int capacity;
    // 实际数据量
    private int size;
    // 头指针，始终指向队首，
    private int head;
    // 尾指针始终指向队尾(最后 1 个有效数据)下一个元素
    private int tail;
    // 修改次数
    private int modCount;

    public MyArrayCircularDeque(int k) {
        this.capacity = k;
        this.head = 0;
        this.tail = 0;
        queue = new Object[k];
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return (Integer) queue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return (Integer) queue[(tail - 1 + capacity)%capacity];
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        head = (head + 1 ) % capacity;
        size--;
        modCount++;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        size--;
        modCount++;
        return true;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        head = (head - 1 + capacity) % capacity;
        queue[head] = value;
        size++;
        modCount++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }

        queue[tail] = value;
        tail = (tail + 1) % capacity;

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

}
