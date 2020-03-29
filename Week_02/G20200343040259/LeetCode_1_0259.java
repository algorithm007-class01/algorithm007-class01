import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class l1twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[]{map.get(diff), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }

    }
}
