var preorderTraversal = function(root) {
    if(!root) return [];
    let ans =[];
    let tmp =[root];

    while(tmp.length){
        let node = tmp.pop();
        ans.push(node.val);

        node.right && tmp.push(node.right);
        node.left && tmp.push(node.left);
    }

    return ans;
};