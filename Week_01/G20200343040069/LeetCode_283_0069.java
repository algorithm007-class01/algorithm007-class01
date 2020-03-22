import java.util.Arrays;

public class LeetCode_283_0069 {

    // 3.用0补位 O(n)
    public void moveZeroes(int[] nums) {
        int j = 0;// 待填入非0元素的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];

                // 用0补充数组空位
                if (i != j) {
                    nums[i] =0;
                }
                j++;
            }
        }
    }

    // 2.swap O(n)
    public void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    // 1.2层 循环  O(n)
    public void moveZeroes2(int[] nums) {
        int idx = 0;
        for(int num : nums) {
            if(num != 0){
                nums[idx++] = num;
            }
        }

        while (idx < nums.length){
            nums[idx++] = 0;
        }
    }

}