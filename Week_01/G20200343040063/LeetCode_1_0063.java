class Solution {
       // 目前唯一一题自己不看🙈答案写出来的。
   public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            int a = target - nums[i];
            Integer j = map.get(a);
            if(j != null ){
                return new int[]{i,j};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}