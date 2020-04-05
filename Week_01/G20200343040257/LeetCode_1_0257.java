
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
     * LeetCode 两数之和 暴力解法
     *
     * @param nums   输入数组
     * @param target 目标和
     * @return int[] 数组下标
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] resultArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int result = nums[i] + nums[j];
                    if (result == target) {
                        resultArray[0] = i;
                        resultArray[1] = j;
                        return resultArray;
                    }
                }
            }
        }
        return resultArray;
    }


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

    /**
     * 双指针夹逼解法
     * 由于需要返回的是数组下标，再找到符合条件的数后还需再查找数对应的下标
     *
     * @param nums   输入数组
     * @param target 目标和
     * @return int[] 数组下标
     */
    public static int[] twoSum3(int[] nums, int target) {
        int m = 0, n = 0, tempIndex = -1;
        int[] temp = new int[nums.length];
        int[] result = new int[]{-1, -1};
        System.arraycopy(nums, 0, temp, 0, temp.length);
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] > Math.abs(target)) {
                break;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            }
            if (nums[i] + nums[j] < target) {
                i++;
            }
            if (nums[i] + nums[j] == target) {
                m = nums[i];
                n = nums[j];
                break;
            }
        }

        // 根据匹配到符合条件的元素m,n 再次遍历原数组寻找下标
        for (int k = 0; k < temp.length; k++) {
            if (result[0] != -1 & result[1] != -1) {
                break;
            }
            if (temp[k] == m || temp[k] == n) {
                if (result[0] == -1) {
                    result[0] = k;
                } else {
                    result[1] = k;
                }
            }
        }
        return result;
    }


}
