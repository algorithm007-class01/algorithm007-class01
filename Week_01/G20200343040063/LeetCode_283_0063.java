class Solution {

    // 解法1.
    // 可以开一个新的数组 len= nums.len，将不是0的数填充到前面即可
    // 空间复杂度比较高O（n）
    
    // 解法2 ： 不是0的数字往前移动即可。
    public void moveZeroes(int[] nums) {
        //用一个指针来记录0的位置
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0 ){
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}