package com.szp.leetcode.q251_300;

public class A283_Move_zeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            if(null == nums)
                return;
            int length = nums.length;
            int index = 0;
            for (int i = 0; i <length ; i++) {
                if(nums[i] != 0){
                    if(nums[index] != nums[i]){
                        nums[index] = nums[i];
                        nums[i] = 0;
                        index++;
                    }
                }
            }
        }
    }
}
