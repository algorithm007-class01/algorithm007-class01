
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_01_0227 {
    public int[] twoSum(int[] nums, int target) {
        return method1(nums, target);
//        return method2(nums, target);
    }


    /**
     * 暴力解法，直接循环
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] method1(int[] nums, int target) {
        if (nums == null) return null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }

    /**
     * 借助hashMap
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] method2(int[] nums, int target) {
        if (nums == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v) && map.get(v) != i) {
                return new int[]{i, map.get(v)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * error solution
     * 这个解法适合返回数组内的元素，不适合访问下标。舍弃, 除非再拷贝份数组，然后查询数组内的下标，不推荐。
     * @param nums
     * @param target
     * @return
     */
    @Deprecated
    private int[] method3(int[] nums, int target) {
        Arrays.sort(nums);
        //使用双指针
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                return new int[]{nums[start], nums[end]};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new LeetCode_01_0227().method3(new int[]{3, 2, 4}, 6);
    }
}
