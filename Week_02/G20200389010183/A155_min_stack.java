package com.szp.leetcode.q151_200;

import java.util.Stack;

public class A155_min_stack {

    class MinStack {

        Stack<Integer> data;
        int min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<>();
        }

        public void push(int x) {
            if(x <= min){
                data.push(min);
                min = x;
            }
            data.push(x);
        }

        public void pop() {
            if(data.pop() == min){
                min = data.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new A155_min_stack().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        //--> 返回 0.
        System.out.println(minStack.getMin());
        //--> 返回 -2.

    }
}
