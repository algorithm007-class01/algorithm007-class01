class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Nums is null or nums.length is illegal");
        }

        //暴力解法：双重for循环
        //时间复杂度：o(n^)
        //空间复杂度：O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }

        //哈希解法：一层for循环，哈希Map保存遍历过的数字
        //时间复杂度：o(n)
        //空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int temp = target - nums[index];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp) , index};
            }
            map.put(nums[index], index);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}