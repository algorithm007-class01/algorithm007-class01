/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.42%)
 * Likes:    385
 * Dislikes: 0
 * Total Accepted:    54K
 * Total Submissions: 83.5K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
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
function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
var buildTree = function(preorder, inorder) {
  let preorder_idx = 0;
  let map = new Map();

  function helper(in_left, in_right) {
    if (in_left == in_right) return null;

    let root_val = preorder[preorder_idx];
    let root = new TreeNode(root_val);

    let index = map.get(root_val);
    preorder_idx++;

    root.left = helper(in_left, index);
    root.right = helper(index + 1, in_right);

    return root;
  }

  let idx = 0;
  for (let v of inorder) {
    map.set(v, idx++);
  }

  return helper(0, inorder.length);
};

// @lc code=end

