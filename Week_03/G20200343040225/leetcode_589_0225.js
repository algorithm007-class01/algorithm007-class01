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
    let list = [];
    (function (root) {
        if(!root) return
        list.push(root.val)
        root.children.forEach(item=>{
            arguments.callee(item)
        })
    })(root)
    return list
};
