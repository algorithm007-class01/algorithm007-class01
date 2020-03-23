package Week_01.G20200343040179;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LeetCode_1_0179 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                res[0] = i;
                res[1] = map.get(value);
                Arrays.sort(res);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;

    }

}