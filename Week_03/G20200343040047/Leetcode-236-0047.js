/**
 * 236. 二叉树的最近公共祖先 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

var lowestCommonAncestor = function(root, p, q) {
  function bst(node) {
    if (!node) return;
    bst(node.left);
    bst(node.right);
    if (node.target === undefined) node.target = { p: null, q: null };
    if (
      node.val === p.val ||
      (node.left && node.left.target && node.left.target.p) ||
      (node.right && node.right.target && node.right.target.p)
    ) {
      node.target.p = true;
    }
    if (
      node.val === q.val ||
      (node.left && node.left.target && node.left.target.q) ||
      (node.right && node.right.target && node.right.target.q)
    ) {
      node.target.q = true;
    }
    if (node.target.p === true && node.target.q === true) {
      if (ans === null) ans = node;
      return;
    }
  }
  let ans = null;
  bst(root);
  return ans;
};
