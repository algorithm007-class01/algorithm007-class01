var levelOrder = function(root) {
    if(!root) return [];
    let ans = [];
    let preLevel = [root];

    while(preLevel.length){
        nodes = preLevel.slice();
        preLevel = [];
        let tmp = [];
        for(let i = 0; i< nodes.length; i++){
            let node = nodes[i];
            tmp.push(node.val);
            if(node.children) preLevel = preLevel.concat(node.children);
        }
        ans.push(tmp);
    }
    return ans;
};