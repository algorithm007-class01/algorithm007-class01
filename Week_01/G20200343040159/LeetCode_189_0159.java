 /**
*
* 189. 旋转数组 <p>
* https://leetcode-cn.com/problems/rotate-array/
*/
public class Solution {
    public int[] rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return nums;
        }
        k%=nums.length;

        for(int i=0;i<k;i++){
            int temp=nums[nums.length-1];//7
            for(int j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1]; 
            }
            nums[0]=temp;
        }

        return nums;
    }
}
