import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (lookup.containsKey(another)) {
                results[0] = lookup.get(another);
                results[1] = i;
                break;
            }
            lookup.put(nums[i], i);
        }

        return results;
    }
}