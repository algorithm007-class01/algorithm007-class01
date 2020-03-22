class Solution {
    // 使用hash table加速查询，Ｏ(n)时间复杂度
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(target - nums[i])) {
                return new int[]{store.get(target - nums[i]), i};
            }
            store.put(nums[i], i);
        }
        return new int[0];
    }
}