

public TreeNode buildTree(int[] preOrder, int[] inOrder) {
    return helper(0, 0, inOrder.length - 1, preOrder, inOrder);
}

public helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
    if(inStart > inEnd || preStart > preOrder.length - 1) {
        return null;
    }

    TreeNode root = new TreeNode(preOrder[preStart]);
    int inIndex = 0;
    for(int i = inStart; i <= inEnd; i ++) {
        if (inOrder[i] == root.val) {
            inIndex = i;
        }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preOrder, inOrder);
    root.right = helper(preStart + inIndex - InStart + 1, inIndex + 1, inEnd, preOrder, inOrder);
    return root;
}