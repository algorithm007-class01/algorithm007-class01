import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0145 {
    /**
     * 两数之和
     */
    public  int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.get(complement) != null && map.get(complement) != i) {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
