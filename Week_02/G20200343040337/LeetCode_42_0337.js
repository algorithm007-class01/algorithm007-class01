/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (49.14%)
 * Likes:    946
 * Dislikes: 0
 * Total Accepted:    64.7K
 * Total Submissions: 130.7K
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
  let st = [];
  st.peak = function () {
    return this[this.length - 1];
  };
  st.empty = function () {
    return this.length == 0;
  };

  let ans = 0;
  for (let i = 0; i < height.length; i++) {
    while (!st.empty() && height[i] > height[st.peak()]) {
      let cur = st.pop();
      if (st.empty()) break;
      let distance = i - st.peak() - 1;
      let deep = Math.min(height[i], height[st.peak()]) - height[cur];
      ans += distance * deep;
    }
    st.push(i);
  }
  return ans;
};
// @lc code=end

