

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class LeetCode_283_MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length){
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] arrays = {0,1,0,3,12};
        moveZeroes(arrays);
        for (int array : arrays) {
            System.out.print(array);
            System.out.print(" ");
        }
    }

}
