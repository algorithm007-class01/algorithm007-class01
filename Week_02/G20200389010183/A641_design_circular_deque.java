package com.szp.leetcode.q601_650;

public class A641_design_circular_deque {
    class MyCircularDeque {
        private Object[] elements;
        private int head, tail, total = 0, capacity;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            elements = new Object[k + 1];
            head = 0;
            tail = 0;
            capacity = k + 1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (total == capacity - 1)
                return false;
            total++;
//            System.out.println("total:" + total);
//            System.out.println("capacity:"+capacity);
            head = (head - 1 + capacity) % capacity;
            elements[head] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (total == capacity - 1)
                return false;
            total++;
//            System.out.println("total:" + total);
//            System.out.println("capacity:"+capacity);
            elements[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (total == 0)
                return false;
            total--;
//            System.out.println("total:" + total);
//            System.out.println("capacity:"+capacity);
            elements[head] = null;
            head = (head + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (total == 0)
                return false;
            total--;
//            System.out.println("total:" + total);
//            System.out.println("capacity:"+capacity);
            elements[tail - 1] = null;
            tail = (tail - 1 + capacity) % capacity;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (total == 0)
                return -1;
            return (Integer) elements[head];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (total == 0)
                return -1;
            return (Integer) elements[(tail - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return total == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return total == capacity - 1;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new A641_design_circular_deque().new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());

    }
/**
 MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 circularDeque.insertLast(1);			        // 返回 true
 circularDeque.insertLast(2);			        // 返回 true
 circularDeque.insertFront(3);			        // 返回 true
 circularDeque.insertFront(4);			        // 已经满了，返回 false
 circularDeque.getRear();  				// 返回 2
 circularDeque.isFull();				        // 返回 true
 circularDeque.deleteLast();			        // 返回 true
 circularDeque.insertFront(4);			        // 返回 true
 circularDeque.getFront();				// 返回 4
 */
}
