/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (73.40%)
 * Likes:    234
 * Dislikes: 0
 * Total Accepted:    41.6K
 * Total Submissions: 56.7K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let output = [];
  function backtrack(first = 1, curr = []) {
    if (curr.length == k) {
      output.push(curr.slice());
    }
    for (let i = first; i < n + 1; i++) {
      curr.push(i);
      backtrack(i + 1, curr);
      curr.pop();
    }
  }

  backtrack()
  return output;
};
// @lc code=end

