package app;
public class LeetCode_189_0333{
    public void rotate(int[] nums, int k) {
        if(null==nums||nums.length==1){
            return;
        }
        if(nums.length<k){
            k%=nums.length;//变成了环形旋转了 向右旋转nums.length次后又继续从头开始旋转 简化算法 就是余数
        }
        reverse(nums,0,nums.length);//rotate all the entry
        reverse(nums,0,k);//rotate k entries from pos=0
        reverse(nums,k,nums.length);//rotate length-k  entries from pos=k
    }

    private void reverse(int[] nums, int pos, int length) {
        int right=length-1;
        int left=pos;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            ++left;
            --right;
        }
    }
}