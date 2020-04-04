// 给定一个二叉树，返回它的 前序 遍历。

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
    const nums = [];
    const rights = [];
    let cur = root;
    while(cur) {
        nums.push(cur.val);
        if(cur.right) {
            rights.push(cur.right);
        }
        if(cur.left) {
            cur = cur.left;
        }else {
            cur = rights.pop();
        }
    }
    return nums;
};