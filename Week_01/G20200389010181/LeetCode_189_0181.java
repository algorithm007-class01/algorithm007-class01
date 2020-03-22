package com.bai.leetcode.editor.en;

/**
 * @author Bai
 */
public class LeetCode_189_0181 {

    /**
     * 189. 旋转数组
     * <p>
     * 思路：
     * 先写出 k = 1 的逻辑
     * 容易想到 k > 1 与 k = 1 本质是一个原理
     * 找出 k > 1 与 k = 1 看似变化实则相同的规律
     * </p>
     * <p>
     * 官方答案中第三种和我这个思路是一样的, 搬运一段官方评论:
     * 环状替代和我的思路一致，不过我觉得这样解释可能更容易理解。
     * 把元素看做同学，把下标看做座位，大家换座位。第一个同学离开座位去第k+1个座位，
     * 第k+1个座位的同学被挤出去了，他就去坐他后k个座位，如此反复。
     * 但是会出现一种情况，就是其中一个同学被挤开之后，坐到了第一个同学的位置（空位置，没人被挤出来），
     * 但是此时还有人没有调换位置，这样就顺着让第二个同学换位置。
     * 那么什么时候就可以保证每个同学都换完了呢？n个同学，换n次，所以用一个count来计数即可。
     * </p>
     */
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k % nums.length == 0) {
            return;
        }
        int start = 0;
        int currVal = nums[0];
        int changeCount = 0;
        int nextIndex = 0;
        while (changeCount != nums.length) {
            nextIndex = (nextIndex + k) % nums.length;
            int tmp = nums[nextIndex];
            nums[nextIndex] = currVal;

            // 跳转只有两种情况，一种全部遍历到，一种有遗漏但回到起点
            if (nextIndex == start) {
                nextIndex = start + 1;
                start++;
                currVal = nums[nextIndex];
            } else {
                currVal = tmp;
            }
            changeCount++;
        }
    }
}
