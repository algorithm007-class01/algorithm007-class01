/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.45%)
 * Likes:    410
 * Dislikes: 0
 * Total Accepted:    37.6K
 * Total Submissions: 111.8K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
class Solution {
    // 贪心算法
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 从位置i与位置i的最大跳远位置之间的数字中，找出能跳的最远的位置，作为下一次跳跃到的位置
            int maxPositionI = i + nums[i];
            if (maxPositionI > maxPosition) {
                maxPosition = maxPositionI;
            }
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    // 通过两层循环找出每一步能跳的最远位置
    public int jump1(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return 0;
        }

        int steps = 0;
        int currentPosition = 0;
        while (true) {
            if (currentPosition >= nums.length - 1) {
                return steps;
            }
            if (currentPosition + nums[currentPosition] >= nums.length - 1) {
                return ++steps;
            }

            int num = nums[currentPosition];
            int nextPosition = currentPosition + 1;
            int maxNextNextPosition = nextPosition;
            for (int j = 1; j <= num; j++) {
                if (currentPosition + j >= nums.length) {
                    break;
                }

                int nextNextPosition = nums[currentPosition + j] + currentPosition + j;
                if (nextNextPosition > maxNextNextPosition) {
                    maxNextNextPosition = nextNextPosition;
                    nextPosition = currentPosition + j;
                }
            }
            currentPosition = nextPosition;
            steps++;
        }
    }
}
// @lc code=end

