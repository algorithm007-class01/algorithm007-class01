class Solution {
    public int[] twoSum(int[] nums, int target) {
        final LinkedHashMap<Integer, Integer> store = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(target - nums[i])) {
                return new int[]{store.get(target - nums[i]), i};
            } else {
                store.put(nums[i], i);
            }
        }
        return new int[0];
    }
}