import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (47.81%)
 * Likes:    7844
 * Dislikes: 0
 * Total Accepted:    897.3K
 * Total Submissions: 1.9M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
class Solution {

    // 基于哈希映射
    // 1.将数字作为键，数字的值作为索引放入哈希映射中
    // 2.遍历所有数字，使用target减去当前数字，得到当前数字的配对数字，
    // 3.到HashMap中查找配对数字的索引，如果找到了且配对数字的索引与当前数字的索引不同，说明配对成功。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer targetIndex = map.get(target - nums[i]);
            if (null == targetIndex || targetIndex.intValue() == i) {
                continue;
            }
            return new int[] { i, targetIndex.intValue() };
        }
        return new int[0];
    }

    // 暴力破解法
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}
// @lc code=end

