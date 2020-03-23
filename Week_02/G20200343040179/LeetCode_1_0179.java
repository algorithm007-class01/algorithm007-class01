import java.util.HashMap;
import java.util.Map;

class LeetCode_1_0179 {

    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        if (nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.get(temp) == null) {
                map.put(nums[i], i);
            } else {
                arr[0] = map.get(temp);
                arr[1] = i;
            }
        }
        return arr;
    }

}