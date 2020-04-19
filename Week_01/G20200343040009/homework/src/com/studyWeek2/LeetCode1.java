package com.studyWeek2;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 将target = num1 + num2 变为 num2 = target - num1，题目就变为找到符合的num2
 * 2. 
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
