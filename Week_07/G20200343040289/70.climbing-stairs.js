/*
 * @lc app=leetcode id=70 lang=javascript
 *
 * [70] Climbing Stairs
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
  if (!n) return 1;

  let f = new Array(n + 1);
  f[1] = 1;
  f[2] = 2;

  for (let i = 3; i < n + 1; i++) {
    f[i] = f[i - 1] + f[i - 2];
  }

  return f[n];
};
// @lc code=end
