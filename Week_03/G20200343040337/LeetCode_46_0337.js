/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (74.52%)
 * Likes:    577
 * Dislikes: 0
 * Total Accepted:    95.1K
 * Total Submissions: 127.7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let output = [];
  let n = nums.length;
  function swap(arr, i, j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  function backtrack(first = 0) {
    if (first == n) {
      output.push(nums.slice());
    }
    for (let i = first; i < n; i++) {
      swap(nums, first, i);
      backtrack(first + 1);
      swap(nums, first, i);
    }
  }

  backtrack();
  return output;
};
// @lc code=end

