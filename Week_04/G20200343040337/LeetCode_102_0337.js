/*
 * @lc app=leetcode.cn id=102 lang=javascript
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (61.30%)
 * Likes:    424
 * Dislikes: 0
 * Total Accepted:    97.2K
 * Total Submissions: 158.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  let result = [];
  if (!root) return result;
  function traversal(nodeList) {
    if (!nodeList.length) return;
    let next_list = [];
    let current_result = []
    for (let i = 0; i < nodeList.length; i++) {
      current_result.push(nodeList[i].val);
      nodeList[i].left && next_list.push(nodeList[i].left);
      nodeList[i].right && next_list.push(nodeList[i].right);
    }
    result.push(current_result);
    traversal(next_list);
  }
  traversal([root]);
  return result;
};
// @lc code=end

