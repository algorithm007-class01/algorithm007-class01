/*
 * @lc app=leetcode id=46 lang=javascript
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (60.61%)
 * Likes:    3230
 * Dislikes: 95
 * Total Accepted:    535.2K
 * Total Submissions: 879.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 *
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let r = [];

  generate(r, [], nums);

  return r;
};

function generate(r, t, n) {
  if (t.length === n.length) {
    r.push(t.slice());
    return;
  }

  for (let i = 0; i < n.length; i++) {
    if (t.includes(n[i])) continue;

    t.push(n[i]);
    generate(r, t, n);
    t.pop();
  }
}
// @lc code=end
