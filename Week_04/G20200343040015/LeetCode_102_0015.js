/**
 * 102. 二叉树的层序遍历
 * 
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 二叉树：[3,9,20,null,null,15,7],
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
    if(!root) return [];
    let res = [],queue = [root];
    while(queue.length){
        let arr=[],temp = [];
        while(queue.length){
            let curr = queue.shift();
            arr.push(curr.val);
            if(curr.left) temp.push(curr.left);
            if(curr.right) temp.push(curr.right);
        }
        queue = temp;
        res.push(arr);
    }
    return res;
};