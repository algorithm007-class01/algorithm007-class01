package com.szp.leetcode.q1_50;

import java.util.HashMap;
import java.util.Map;

public class A1_TwoSum {
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(null == nums || nums.length == 0)
                return null;
            Map<Integer, Integer> record = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if (record.containsKey(target - nums[i]))
                    return new int[]{record.get(target - nums[i]), i};
                record.put(nums[i], i);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new A1_TwoSum().new Solution().twoSum(new int[]{2,7,11,15}, 9)[0]);
        System.out.println(new A1_TwoSum().new Solution().twoSum(new int[]{2,7,11,15}, 9)[1]);
//        System.out.println(String::new);

    }
}
