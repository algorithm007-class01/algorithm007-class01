/**
 * 1. 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 在哈希表中进行查找的用时应当被摊销为 O(1)
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}