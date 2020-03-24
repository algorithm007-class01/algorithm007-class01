package com.studyWeek1;

/**
 * 盛最多水的容器
 * 思路：
 * 1. 利用头尾指针
 * 2. 两条边，y轴取短边作为宽，x轴两点距离作为长
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int s = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, s);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
