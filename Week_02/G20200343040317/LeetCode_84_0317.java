class Solution {
    // 使用栈来走一个
    public int largestRectangleArea(int[] heights) {
        final Stack<Integer> stack = new Stack<>();
        // 存放的是元素在数组中的位置
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 处理栈余下的数据
        // 栈里面的情况都是数组右比当前大的数据，所以右边界是heights.length
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}