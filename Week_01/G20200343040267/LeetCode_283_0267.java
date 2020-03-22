/**
 * 283. 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                lastNonZeroFoundAt = i;
                break;
            }
        }

        if (lastNonZeroFoundAt != -1) {
            for (int cur = lastNonZeroFoundAt; cur < nums.length; cur++) {
                if (nums[cur] != 0) {
                    nums[lastNonZeroFoundAt++] = nums[cur];
                    nums[cur] = 0;
                }
            }
        }
    }
}