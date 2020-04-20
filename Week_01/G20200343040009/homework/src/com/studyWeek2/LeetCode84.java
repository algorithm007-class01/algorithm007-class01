package com.studyWeek2;

import java.util.Stack;

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // -1作用：中断循环
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));

            stack.push(i);
        }
        while (stack.peek() != -1)
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));

        return maxArea;
    }
}


