class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums is illegal");
        }

       //1.暴力解法双层for循环：时间复杂度O（n^2），空间复杂度O（1）
    //    for (int i = 0; i < nums.length; i++) {
    //        for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 return new int[] {i, j};
    //             }
    //        }
    //    } 
    //    throw new IllegalArgumentException("No two sum solution");

       //2.哈希表两边for循环法：时间复杂度O（n），空间复杂度O（n）
    //    Map<Integer, Integer> map = new HashMap<>();
    //    for (int i = 0; i < nums.length; i++) {
    //        map.put(nums[i], i);
    //    }
    //    for (int i = 0; i < nums.length; i++) {
    //        int temp = target - nums[i];
    //        if (map.containsKey(temp) &&  map.get(temp) != i) {
    //            return new int[] {i, map.get(temp)};
    //        }
    //    }
    //    throw new IllegalArgumentException("No two sum solution");

        //3.哈希表一遍for循环法：时间复杂度O（n），空间复杂度O（n）
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}