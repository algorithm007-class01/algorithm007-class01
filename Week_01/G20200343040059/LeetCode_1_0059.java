/**
*   两数之和
*
*   暴力处理也可以
*   这里新加了一个Hash来存储target需要的值和下标，来缩短遍历的时间
*
*   时间复杂度O(n)，空间复杂度O(n)
*
*
**/
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 使用hashmap用来存储 需要的那个数（target-每个值）对应的值和下标
        HashMap<Integer, Integer> map = new HashMap();

        // 直接遍历nums数组
        for (int i = 0; i < nums.length; i++) {

            // 判断如果hashmap存在这个值，就说明这个值和之前的某个数加起来是等于target
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                // 存入target-nums[i]和对应的下标
                // 比如 1 + x = 3,则存入map.put(2,i)
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}