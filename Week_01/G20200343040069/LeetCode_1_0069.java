import java.util.HashMap;

public class LeetCode_1_0069 {

    // 3.hashmap解 O(n) 1遍hash
    public int[] twoSum3(int[] nums, int target) {
        HashMap< Integer, Integer > tracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tracker.containsKey(target - nums[i])){
                return new int[]{tracker.get(target - nums[i]), i};
            }
            tracker.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 2.hashmap解 O(n) 2遍hash
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap< Integer, Integer > tracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tracker.put(nums[i], i);
        }
        for (int i = 0; i <nums.length ; i++) {

            if (tracker.containsKey(target - nums[i])){
                if (i != tracker.get(target - nums[i])){
                    res[0] = i;
                    res[1] = tracker.get(target - nums[i]);
                    return res;
                }
            }
        }
        return res;
    }

    // 1.暴力求解 O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (target == nums[i] + nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
