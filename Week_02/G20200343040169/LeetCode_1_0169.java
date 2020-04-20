/**
 * 一遍哈希法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}

/**
 * 暴力法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}

/**
 * 两遍哈希法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < n - 1; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{ i,map.get(complement) };
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}