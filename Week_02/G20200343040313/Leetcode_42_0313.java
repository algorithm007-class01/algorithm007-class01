package l01.n42;//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1. 按列求
 * 根据较矮的那个墙和当前列的墙的高度可以分为三种情况
 * 1. 较矮的墙的高度大于当前列的墙的高度
 * 2. 较矮的墙的高度小于当前列的墙的高度
 * 3. 较矮的墙的高度等于当前列的墙的高度。
 */
class Solution42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 找到左边最高的墙
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            // 找到右边最高的墙
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            // 左右最小的墙
            int minMax = Math.min(maxLeft, maxRight);
            if (minMax > height[i]) {
                sum += (minMax - height[i]);
            }
        }
        return sum;

    }
}

class Solution42_1 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        int cur = 0;
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int dis = cur - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[cur]);
                sum += (min - top) * dis;

            }
            stack.push(cur++);
        }
        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
