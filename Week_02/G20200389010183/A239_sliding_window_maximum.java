package com.szp.leetcode.q201_250;
/*
* 示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

链接：https://leetcode-cn.com/problems/sliding-window-maximum
* */
public class A239_sliding_window_maximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(null == nums || nums.length == 0)
                return new int[0];
            if(nums.length ==  1)
                return new int[]{nums[0]};

            int len = nums.length;
            int n = len - k + 1;
            int[] res = new int[n];
            int max;
            for (int i = 0; i < n; i++) {
                max = nums[i];
                for (int j = 1; j < k; j++) {
                    if(nums[j + i] > max)
                        max = nums[j+i];
                }
                res[i] = max;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A239_sliding_window_maximum().new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        for (int i : solution.maxSlidingWindow(nums, 3)) {
            System.out.println(i);
        }
    }
}
