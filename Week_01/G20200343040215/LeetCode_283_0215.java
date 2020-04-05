package Week_01;

public class LeetCode_283_0215 {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) {
                if (j!=i) {//判断
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
