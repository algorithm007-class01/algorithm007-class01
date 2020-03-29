/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
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
    let arr=[],res=[];
    root&&arr.push(root)
    while(arr.length>0){
        let cur = arr.pop();
        res.push(cur.val);
        cur.right && arr.push(cur.right);
        cur.left && arr.push(cur.left);
    }
    return res;
};