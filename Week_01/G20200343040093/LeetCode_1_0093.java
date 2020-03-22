class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> storage = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            int res = target - nums[i];
            if (storage.containsKey(res)) {
                return new int[]{storage.get(res) ,i};
            }
            storage.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}