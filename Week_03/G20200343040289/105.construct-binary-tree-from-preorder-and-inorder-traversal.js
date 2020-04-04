/*
 * @lc app=leetcode id=105 lang=javascript
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (46.02%)
 * Likes:    2734
 * Dislikes: 79
 * Total Accepted:    314.1K
 * Total Submissions: 679.7K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  return build(0, 0, inorder.length - 1, preorder, inorder);
};

function build(preStart, inStart, inEnd, preorder, inorder) {
  if (preStart > preorder.length - 1 || inStart > inEnd) {
    return null;
  }

  const root = { val: preorder[preStart], left: null, right: null };
  let inIndex = 0;

  for (let i = inStart; i <= inEnd; i++) {
    if (inorder[i] === root.val) {
      inIndex = i;
    }
  }

  root.left = build(preStart + 1, inStart, inIndex - 1, preorder, inorder);
  root.right = build(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

  return root;
}
// @lc code=end
