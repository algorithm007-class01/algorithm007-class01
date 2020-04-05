/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (57.78%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    47.2K
 * Total Submissions: 81.7K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  function dfs(nums, size, depth, path, used, res) {
    if (depth == size) {
      res.push(path.slice())
      return;
    }
    for (let i = 0; i < size; i++) {
      if (!used[i]) {
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
          continue;
        }
        used[i] = true;
        path.push(nums[i]);
        dfs(nums, size, depth + 1, path, used, res);
        used[i] = false;
        path.pop()
      }
    }
  }
  let size = nums.length;
  if (size == 0) return [];

  nums.sort()

  used = [];
  for (let i = 0; i < nums.length; i++) {
    used.push(false);
  }
  let res = [];
  dfs(nums, size, 0, [], used, res);
  return res;
};
// @lc code=end

