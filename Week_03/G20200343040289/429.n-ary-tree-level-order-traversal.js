/*
 * @lc app=leetcode id=429 lang=javascript
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (62.77%)
 * Likes:    456
 * Dislikes: 40
 * Total Accepted:    63.1K
 * Total Submissions: 100.2K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 *
 * Example 2:
 *
 *
 *
 *
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 *
 *
 * Constraints:
 *
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 *
 *
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (root === null) return [];

  let r = [];
  let s = [root];

  while (s.length !== 0) {
    let len = s.length;
    let t = [];

    for (let i = 0; i < len; i++) {
      root = s.shift();

      t.push(root.val);

      if (root.children && root.children.length) {
        for (let c of root.children) {
          s.push(c);
        }
      }
    }

    r.push(t);
  }

  return r;
};
// @lc code=end
