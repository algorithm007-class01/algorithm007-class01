/**
 * 144. 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
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
  let arr = [];
  pre(root, arr);
  return arr;
};

var pre = function(root, arr) {
  if (root == null) {
    return;
  }
  arr.push(root.val);
  pre(root.left, arr);
  pre(root.right, arr);
  return arr;
};
