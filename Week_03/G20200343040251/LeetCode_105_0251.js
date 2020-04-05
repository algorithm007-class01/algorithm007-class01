var buildTree = function(preorder, inorder) {
    if(inorder.length == 0) return null;
    let root = new TreeNode(preorder[0]);
    let rootIndex = inorder.indexOf(root.val);
    root.left = buildTree(preorder.slice(1, rootIndex+1), inorder.slice(0, rootIndex));
    root.right = buildTree(preorder.slice(rootIndex+1), inorder.slice(rootIndex+1));
    return root;
    
};