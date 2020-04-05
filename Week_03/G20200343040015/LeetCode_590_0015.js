/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
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
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    if(!root) return [];
    
    let res=[],arr=[root];
    while(arr.length){
        let cur = arr.pop();
        for(let i=0;i<cur.children.length;i++){
            arr.push(cur.children[i]);
        }
        res.unshift(cur.val);
    }
    
    return res;  
    return res;  
};