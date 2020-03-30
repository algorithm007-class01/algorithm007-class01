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
 * 前序遍历
 */
var preorder = function(root) {
    if(!root||root.length == 0)return [];
    let list = [];
    (function (root){
    if(!root) return
    list.push(root.val)  //先根节点   再子节点
    root.children.forEach(item=>{
      arguments.callee(item)
    })
  })(root)
  return list
};