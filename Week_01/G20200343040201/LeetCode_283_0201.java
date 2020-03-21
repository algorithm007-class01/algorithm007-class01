public class LeetCode_283_0201 {
    public void moveZeroes(int[] nums) {
        for (int i = 0, target = 0; i < nums.length; i++) {
            // 如果快指针找到非零元素，如果是0，就越过去
            if (nums[i] != 0) {
                /**
                 * 如果快慢指针不相等，说明快指针之前已经跨过了0元素
                 * 并且此时target指向的是0，这个时候把快指针所指的元素值给慢指针所指的位置
                 * 快指针所指元素赋0（相当交换值）
                 */
                if (target != i) {
                    nums[target] = nums[i];
                    nums[i] = 0;
                }
                // 慢指针所指位置填了一个非零值，加1，继续往后面推进
                target++;
            }
        }
    }
}
