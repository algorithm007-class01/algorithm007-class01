/**
*1. 两数之和 <p>
* https://leetcode-cn.com/problems/two-sum/    
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] datas=new int[2];
        label:
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    datas[0]=i;
                    datas[1]=j;
                    break label;
                }
            }
        }

        return datas;
    }
}