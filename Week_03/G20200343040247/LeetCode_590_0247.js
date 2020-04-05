/**
 *  N叉树的后序遍历
 */
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    if(!root) return []
  let list = []
  ;(function (root){
    if(!root) return
    root.children.forEach(item=>{
      arguments.callee(item)
    })
    list.push(root.val)
  })(root)
  return list
};