class Solution {
    TreeNode node;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAnce(root, p.val, q.val);
        return node;
    }

    private int findLowestCommonAnce(TreeNode root, int p, int q) {
        if (root == null) return 0;

        int mid = 0;

        int left = findLowestCommonAnce(root.left, p, q);
        if (root.val == p || root.val == q) mid = 1;
        int right = findLowestCommonAnce(root.right, p, q);

        if (left + mid + right >= 2) {
            node = root;
            return 1;
        }
        if (left + mid + right == 0)
            return 0;
        else return 1;
    }
}