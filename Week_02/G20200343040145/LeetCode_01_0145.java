import java.util.HashMap;
import java.util.Map;

public class LeetCode_01_0145 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if (map.get(complete) != null) {
                return new int[]{map.get(complete), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
