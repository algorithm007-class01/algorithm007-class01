
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

    /**
     * 解法1 优化
     * @param nums 数组
     * @param k 旋转次数
     */
    public void rotateOptimised1(int[] nums, int k) {
        int endIndex = nums.length - 1;
        int prev;
        int temp;
        int length = nums.length;
        int rotateTimes = k;
        if(k == length || k ==0){
            return;
        }
        if(k > length){
            rotateTimes = k%length;
        }
        while (rotateTimes>0){
            prev = nums[0];
            nums[0] = nums[endIndex];
            for (int i = 1; i < nums.length; i++) {
                temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
            rotateTimes--;
        }
    }

    /**
     * 解法2 翻转法
     * @param nums 数组
     * @param k 旋转次数
     */
    public static void rotate2(int[] nums, int k){
        int length = nums.length;
        int rotateTimes = k;
        if(k == length || k ==0){
            return;
        }
        if(k > length){
            rotateTimes = k%length;
        }
        reserve(nums,0,length-1);
        reserve(nums,0,rotateTimes-1);
        reserve(nums,rotateTimes,length-1);
    }

    /**
     * 翻转数组
     * @param nums 数组
     * @param start 起始索引下标
     * @param end 结束索引下标
     */
    private static void reserve(int[] nums,int start,int end){
        int temp;
        while (start<end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
