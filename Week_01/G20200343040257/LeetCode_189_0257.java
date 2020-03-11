
public class RotateArray {

    /**
     * 解法1
     * @param nums 数组
     * @param k 旋转次数
     */
    public void rotate1(int[] nums, int k) {
        int endIndex = nums.length - 1;
        int prev;
        int temp;
        while (k>0){
            prev = nums[0];
            nums[0] = nums[endIndex];
            for (int i = 1; i < nums.length; i++) {
                temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
            k--;
        }
    }

}
