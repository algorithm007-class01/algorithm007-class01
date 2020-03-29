/*
 * @lc app=leetcode id=144 lang=javascript
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (54.11%)
 * Likes:    1229
 * Dislikes: 52
 * Total Accepted:    445K
 * Total Submissions: 821K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  if (root === null) return [];

  let r = [];
  traversal(root, r);

  return r;
};

function traversal(root, r) {
  if (root === null) return;

  r.push(root.val);

  traversal(root.left, r);
  traversal(root.right, r);
}
// @lc code=end

var preorderTraversal = function(root) {
  if (root === null) return [];
  
  let r = [];
  let s = [root];

  while (s.length !== 0) {
    root = s.pop();

    r.push(root.val);

    if (root.right) s.push(root.right);
    if (root.left) s.push(root.left);
  }

  return r;
};