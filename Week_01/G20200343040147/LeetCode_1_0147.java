import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_0147 {


    /**
     * 1、双层循环
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * 2、缓存一下，查找是否存在
     */
    public int[] twoSum2(int[] nums, int target) {
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

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] r = new LeetCode_1_0147().twoSum2(nums, target);
        System.out.println(Arrays.toString(r));
    }
}
