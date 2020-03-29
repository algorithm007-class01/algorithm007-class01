package LeetCode_02_0177;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
      for (int i = 0 ; i<nums.length; i++) {
          numsMap.put(nums[i],i);
      }

      for (int i = 0 ;i<nums.length; i++) {
          if (numsMap.containsKey(target-nums[i])) {
             return new int [] {i,numsMap.get(target-nums[i])};
          }
      }

      return null;

    }
}
