
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
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
 */
public class LeetCode_1_TwoSum {


    /**
     * Hash表缓存解法
     *
     * @param nums   输入数组
     * @param target 目标和
     * @return int[] 数组下标
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer tempIndex = tempMap.get(target - nums[i]);
            if (tempIndex != null) {
                return new int[]{tempIndex, i};
            }
            tempMap.put(nums[i], i);
        }
        return null;
    }

}
