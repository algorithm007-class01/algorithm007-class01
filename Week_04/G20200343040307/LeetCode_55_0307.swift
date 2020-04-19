/*
 * @lc app=leetcode.cn id=55 lang=swift
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    func canJump(_ nums: [Int]) -> Bool {
        if nums.count < 2{
            return true
        }
        var count = nums.count - 1
        var index = nums.count - 2
        while index >= 0 {
            if nums[index] + index >= count {
                count = index
            }
            index -= 1
        }
        return count == 0
    }
}

// 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
// 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
// 如果可以一直跳到最后，就成功了。
bool canJump(vector<int>& nums) 
{
    int k = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (i > k) return false;
        k = max(k, i + nums[i]);
    }
    return true;
}

// other language
bool canJump(int A[], int n) {
    int i = 0;
    for (int reach = 0; i < n && i <= reach; ++i)
        reach = max(i + A[i], reach);
    return i == n;
}

// @lc code=end

