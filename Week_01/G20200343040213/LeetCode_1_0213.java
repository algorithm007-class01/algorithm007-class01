class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length < 2) return new int[]{};

        // hash map 方式
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}