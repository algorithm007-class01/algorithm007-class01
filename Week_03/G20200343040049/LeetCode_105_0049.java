class Solution {
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        index = 0;
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length);
    }
    private TreeNode build(int lo, int hi) {
        if (lo == hi)
            return null;

        int value = preorder[index++];
        TreeNode tree = new TreeNode(value);
        int mid = map.get(value);

        tree.left = build(lo, mid);
        tree.right = build(mid + 1, hi);

        return tree;
    }
}