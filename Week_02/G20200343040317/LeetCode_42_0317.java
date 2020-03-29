
class Solution {
    public int trap(int[] height) {
        // 使用栈来解决
        // 入参条件判断
        if (height.length < 3) {
            return 0;
        }
        final Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pre = stack.pop();
                // 这里一定要再次判断!stack.isEmpty()
                if (!stack.isEmpty()) {
                    ans += (Math.min(height[i], height[stack.peek()]) - height[pre]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}