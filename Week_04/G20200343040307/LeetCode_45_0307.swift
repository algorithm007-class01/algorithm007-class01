/*
 * @lc app=leetcode.cn id=45 lang=swift
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
// 最小跳跃次数
// 贪心算法 - 每次取局部最优 
	// 1. 每次取起跳区间的最大值，第一是 0 到 0，第二次就是 从 1 到 nums[0]
	// 2. 从后往前贪心，第一次取最远能到达末端的位置，将末端赋值成当前位置然后再找第二个离新末端最近的位置
class Solution {
    func jump(_ nums: [Int]) -> Int {
        var count = 0
        var end = 0
        var distance = 0
        for i in 0..<nums.count - 1 {
            distance = max(distance, i + nums[i])
            if i == end {
                end = distance
                count += 1
            }
        }
        return count
    }
}

// other
public int jump(int[] nums) {
    int position = nums.length - 1; //要找的位置
    int steps = 0;
    while (position != 0) { //是否到了第 0 个位置
        for (int i = 0; i < position; i++) {
            if (nums[i] >= position - i) {
                position = i; //更新要找的位置
                steps++;
                break;
            }
        }
    }
    return steps;
}
// @lc code=end

