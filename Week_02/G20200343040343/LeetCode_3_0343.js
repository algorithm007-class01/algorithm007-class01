/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (49.36%)
 * Likes:    946
 * Dislikes: 0
 * Total Accepted:    65K
 * Total Submissions: 131.3K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  // 1. 遍历计算每一列的雨水
  let res = 0
  for (let i = 1; i < height.length - 1; i++) {
    let j = i - 1, k = i + 1
    let lm = 0, rm = 0
    while (j > -1) {
      lm = Math.max(lm, height[j--])
    }
    while (k < height.length) {
      rm = Math.max(rm, height[k++])
    }
    const m = Math.min(lm, rm)
    if (m > height[i]) {
      res += m - height[i]
    }
  }
  return res
};
// @lc code=end

