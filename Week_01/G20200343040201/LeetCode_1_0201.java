import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0201 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                // 这里放进去hashmap的是"与target的差值"，是一个小的关键点
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
