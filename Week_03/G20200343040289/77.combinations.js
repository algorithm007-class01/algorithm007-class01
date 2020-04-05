/*
 * @lc app=leetcode id=77 lang=javascript
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (52.31%)
 * Likes:    1212
 * Dislikes: 61
 * Total Accepted:    263.6K
 * Total Submissions: 502.2K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 *
 * Example:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 *
 *
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let r = [];

  generate(r, [], 1, n, k);

  return r;
};

function generate(r, t, s, n, k) {
  if (t.length === k) {
    r.push(t.slice());
    return;
  }

  for (let i = s; i < n + 1; i++) {
    t.push(i);
    generate(r, t, i + 1, n, k);
    t.pop();
  }
}
// @lc code=end
