package arithmetic.leetcode;

public class Rotate {

    //每次前进一次 ，循环k次;
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int j = 0; j < k; j++) {
            int pre = nums[nums.length -1];
            for (int i = 0; i < nums.length; i++) {
                int tmp = nums[i];
                nums[i] = pre;
                pre = tmp;
            }
        }
    }

    //反转方法
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int i1) {
        while (i < i1) {
            int tmp = nums[i];
            nums[i] = nums[i1];
            nums[i1] = tmp;
            i++;
            i1--;
        }
    }
}
