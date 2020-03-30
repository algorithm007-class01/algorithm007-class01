var preorder = function(root) {
    if(!root) return [];
    let ans =[];
    let tmp =[root];

    while(tmp.length){
        let node = tmp.pop();
        ans.push(node.val);
        let len =0;
        if(len = node.children.length){
            for(let i = len-1; i>=0;i--){
                tmp.push(node.children[i]);
            }
        }
    }
    return ans;
};