// 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if(!root) {
        return [];
    }
    let nextLevelNodes = [root];
    const numss = [];
    let nums;
    while(nextLevelNodes.length) {
        nums = [];
        nextLevelNodes.forEach(s => {
            nums.push(s.val);
        });
        numss.push(nums);
        nextLevelNodes = nextLevelNodes.reduce((c, n) => {
            if(n.children) {
                c.push(...n.children);
            }
            return c;
        }, [])
    }
    return numss;
};