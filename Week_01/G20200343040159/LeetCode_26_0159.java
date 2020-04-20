/**
*
* 26. 删除排序数组中的重复项 <p>
* https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
*/
public class Solution {
  public int removeDuplicates(int[] nums) {
        int p=0;
        for(int i=1;i<nums.length;i++){
            if(nums[p]!=nums[i]){
                nums[++p]=nums[i];
            }
        }

        return p+1;
    }
}