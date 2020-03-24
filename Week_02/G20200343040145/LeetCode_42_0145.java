import java.util.Stack;

public class LeetCode_42_0145 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
     * 计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 时间复杂度 O(n)
     */
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length) {
            /**
             *  height[cur] > height[stack.peek()] 说明 两个柱子间可能有积水,计算积水数量
             * */
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.peek()];
                /**
                 * 先用h记录上一次peek时柱子的高度
                 * 然后取出下一个栈元素的高度
                 * */
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int min = Math.min(height[cur], height[stack.peek()]);
                int dis = cur - stack.peek() - 1;
                res += (min - h) * dis;
            }
            stack.push(cur);
            cur++;
        }
        return res;
    }
}
