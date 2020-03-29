
// ######### N叉树的前序遍历###########

var preorder = function(root) {
    if (!root) return [];

    var res = [];
    recusion(root);
    return res;

    function recusion(root){
        if (!root) return;

        res.push(root.val);
        for (var i = 0; i < root.children.length; i++){
            recusion(root.children[i]);
        }
    }
};

