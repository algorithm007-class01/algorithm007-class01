/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array
 */
public class l189rotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(nums, k);
        solution.printNums(nums);
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            int[] tmp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                tmp[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < tmp.length; i++) {
                nums[i] = tmp[i];
            }
        }

        public void printNums(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
