/*
 * @lc app=leetcode id=47 lang=javascript
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (44.43%)
 * Likes:    1625
 * Dislikes: 57
 * Total Accepted:    319.9K
 * Total Submissions: 717.5K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 *
 * Example:
 *
 *
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 *
 *
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  let r = [];

  nums.sort((a, b) => a - b);
  backtrack(r, nums, [], new Array(nums.length));

  return r;
};

function backtrack(r, n, t, used) {
  if (t.length === n.length) {
    r.push(t.slice());
    return;
  }

  for (let i = 0; i < n.length; i++) {
    if (used[i] || (i > 0 && n[i] === n[i - 1] && !used[i - 1])) continue;
    used[i] = true;

    t.push(n[i]);
    backtrack(r, n, t, used);

    used[i] = false;
    t.pop();
  }
}
// @lc code=end
