/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 */
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
    
    if(!root) return [];

    var res = [];
    recusion(root);
    return res;

    function recusion(node){
        if(!node) return;
        res.push(node.val);
        for(let i=0;i<node.children.length;i++){
            recusion(node.children[i]);
        }
    }
    
};