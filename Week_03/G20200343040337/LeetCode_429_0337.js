/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (65.01%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 25.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
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
  let result = [];
  if (!root) return result;
  
  function travel(roots) {
    let cur = [];
    for (let i = 0; i < roots.length; i++) {
      cur.push(roots[i].val);
    }
    result.push(cur);

    let nextRoots = [];
    for (let i = 0; i < roots.length; i++) {
      if (roots[i].children && roots[i].children.length) {
        nextRoots = [...nextRoots, ...(roots[i].children)]
      }
    }
    if (nextRoots.length) travel(nextRoots);
  }
  travel([root]);
  return result; 
};
// @lc code=end

