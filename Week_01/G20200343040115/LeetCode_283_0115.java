import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
       if(nums==null|| nums.length==0)return;
       int pos=0;
       for(int num:nums){
           if(num!=0){nums[pos++]=num;}
       }
       while(pos<nums.length){nums[pos++]=0;}
   
    }
}
// @lc code=end

