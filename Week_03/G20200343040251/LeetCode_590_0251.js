var postorder = function(root) {
    if (!root) return [];
    //根右左，反转
    let node = root;
    let ans = [];
    let tmp =[];

    while(node || tmp.length){
        while(node){
            ans.push(node.val);
            let len = node.children.length || 0 ;
            if(len>0){
                for(let i = 0; i<len-1; i++){
                    tmp.push(node.children[i]);
                }
            }
            node = node.children[len-1];
        }
        node = tmp.pop();
    }

    return ans.reverse();
};