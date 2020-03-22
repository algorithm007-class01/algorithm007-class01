//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSum4(nums,target);
    }

    // 暴力双层遍历
    private int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++){
            for (int j=i+1; j< nums.length; j++){
                if( nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    // 哈希表
    private int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            Integer index = map.get(target - nums[i]);
            if(index != null && index != i){
                return new int[]{i,index};
            }
        }
        throw new IllegalArgumentException();
    }

    // 一遍哈希表
    private int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int i1 = target - nums[i];
            Integer index = map.get(i1);
            if(index != null){
                return new int[]{index,i};
            }else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
