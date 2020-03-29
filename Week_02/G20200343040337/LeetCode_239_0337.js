/*
 * @lc app=leetcode.cn id=239 lang=javascript
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (44.48%)
 * Likes:    270
 * Dislikes: 0
 * Total Accepted:    35.4K
 * Total Submissions: 79.2K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 * 
 * ⁠ 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 
 * 提示：
 * 
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
  if (nums.length * k == 0) return [];
  if (1 == k) return nums;

  let dq = [];
  dq.peak = function () {
    return this[this.length - 1];
  };
  dq.empty = function () {
    return 0 == this.length;
  };
  dq.first = function () {
    return this[0];
  }
  dq.clean = function (i) {
    if (!this.empty() && this[0] == i - k) {
      this.splice(0, 1);
    }
    while (!this.empty() && nums[this.peak()] < nums[i]) {
      this.pop();
    }
    this.push(i);
  };

  let result = [];
  for (let i = 0; i < nums.length; i++) {
    dq.clean(i);
    if (i >= k - 1) result.push(nums[dq.first()]);
  }
  return result;
};
// @lc code=end

