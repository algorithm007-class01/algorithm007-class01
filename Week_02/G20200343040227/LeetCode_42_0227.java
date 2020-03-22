package week2.homework;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class LeetCode_42_0227 {
    public int trap(int[] height) {
//        return method1(height);
        //存储相邻的2边的高度即可。然后逐个柱子累加
//        return method2(height);
        //栈解决
        return method3(height);
    }

    /**
     * 使用栈存储
     *
     * @param height
     * @return
     */
    private int method3(int[] height) {
        if (height == null) return 0;
        int size = height.length;
        int current = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < size) {
            //[0,1,0,2,1,0,1,3,2,1,2,1]
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                Integer top = stack.peek();
                stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                res += distance * bounded_height;
            }
            stack.push(current++);
        }
        return res;
    }

    /**
     * 提前存储每个柱子的左右指针,只看当前柱子的相邻的2边即可
     *
     * @param height
     * @return
     */
    private int method2(int[] height) {
        if (height == null) return 0;
        int size = height.length;
        int res = 0;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = 0;
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }

    /**
     * 采用双指针
     *
     * @param height
     * @return
     */
    private int method4(int[] height) {
        if (height == null) return 0;
        int size = height.length;
        int res = 0;
        int left_max = 0;
        int right_max = 0;
        int left = 1;
        int right = size - 2;

        for (int i = 1; i < size - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                left_max = Math.max(left_max, height[left - 1]);
                int min = left_max;
                if (left_max < height[left]) {
                    res += min - height[left];
                }
                left++;

            } else {
                right_max = Math.max(right_max, height[right + 1]);
                int min = right_max;
                if (right_max < height[right]) {
                    res += min - height[right];
                }
                right--;
            }
        }
        return res;
    }

    /**
     * 暴力解法 就是找出每个元素（柱子）上面的水量，加在一起。
     * 计算当前每根柱子的高度和最小高度，最大高度的差值。
     *
     * @param height
     * @return
     */
    private int method1(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            res = Math.min(left, right) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_42_0227().method3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
