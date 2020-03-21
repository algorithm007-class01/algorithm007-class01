class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            Integer v= map.get(target - nums[i]);
            if( v != null){
                return new int[]{i,v};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    
}