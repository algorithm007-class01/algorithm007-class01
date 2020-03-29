import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0147 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> c = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            c.putIfAbsent(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (c.containsKey(b) && c.get(b) != i) {
                result[0] = i;
                result[1] = c.get(b);
                return result;
            }
        }

        return result;
    }

}
