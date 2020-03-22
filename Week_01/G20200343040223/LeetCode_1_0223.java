package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0223 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(target - nums[i]) != null){
                return new int[]{map.get(target - nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
