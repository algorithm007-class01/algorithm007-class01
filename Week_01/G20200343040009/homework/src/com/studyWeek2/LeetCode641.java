package com.studyWeek2;

public class LeetCode641 {
    private int[] deque;

    /**
     * 队列头部
     */
    private int front;

    /**
     * 队列尾部
     */
    private int last;

    /**
     * 容量
     */
    private int cap;

    // 构造函数,双端队列的大小为k
    public LeetCode641(int k) {
        deque = new int[k + 1];

        // 头部指向第 1 个存放元素的位置
        // 插入时，先减，再赋值
        // 删除时，索引 +1（注意取模）
        front = 0;

        // 尾部指向下一个插入元素的位置
        // 插入时，先赋值，再加
        // 删除时，索引 -1（注意取模）
        last = 0;
        cap = k + 1;
    }

    // 将一个元素添加到双端队列头部。 如果操作成功返回 true
    public boolean insertFront(int value) {
        if (isFull()) {
            return Boolean.FALSE;
        }
        deque[front] = value;
        // 求出下一个头部位置
        front = (front + 1) % cap;
        return Boolean.TRUE;
    }

    // 将一个元素添加到双端队列尾部。如果操作成功返回 true
    public boolean insertLast(int value) {
        if (isFull()) {
            return Boolean.FALSE;
        }
        // 求出下一个尾部位置
        last = (last - 1 + cap) % cap;
        deque[last] = value;
        return Boolean.TRUE;
    }

    // 从双端队列头部删除一个元素。 如果操作成功返回 true
    public boolean deleteFront() {
        if (isEmpty()) {
            return Boolean.FALSE;
        }
        front = (front - 1 + cap) % cap;
        return Boolean.TRUE;
    }

    // 从双端队列尾部删除一个元素。如果操作成功返回 true
    public boolean deleteLast() {
        if (isEmpty()) {
            return Boolean.FALSE;
        }
        last = (last + 1) % cap;
        return Boolean.TRUE;
    }

    // 从双端队列头部获得一个元素。如果双端队列为空，返回 -1
    public int getFront() {
        return isEmpty() ? -1 : deque[(front - 1 + cap) % cap];
    }

    // 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
    public int getRear() {
        return isEmpty() ? -1 : deque[last];
    }

    // 检查双端队列是否为空
    public boolean isEmpty() {
        return front == last;
    }

    // 检查双端队列是否满了
    public boolean isFull() {
        return (front + 1) % cap == last;
    }
}
