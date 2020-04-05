/**
 * 94. 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
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
var inorderTraversal = function(root) {
  let res = [];
  help(root, res);
  return res
};

function help(root, res) {
  if (root !== null) {
      help(root.left, res);
      res.push(root.val);
      help(root.right, res);
  }
}