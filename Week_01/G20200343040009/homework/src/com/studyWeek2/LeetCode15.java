package com.studyWeek2;

import java.util.Stack;

/**
 * 1. push：与min比较，如小于min，则原min入栈
 * 2. pop：先与min比较，相等才出栈
 */
public class LeetCode15 {
    private Stack<Integer> stack;

    private int min;

    public LeetCode15() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
