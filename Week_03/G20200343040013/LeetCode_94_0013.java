
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList();

    help(root, list);
    return list;
}

private void helper(TreeNode node, List list) {
    if (node == null) {
        return;
    }
    if(node.left != null) {
        helper(node.left, list);
    }
    list.add(node.val);
    if(node.right != null) {
        helprt(node.right, list);
    }
}