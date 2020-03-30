package leetcode;

public class LeetCode_236_0223 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null) return right;
        if(right == null) return left;
        if(left != null && right != null) return root;
        return null;
    }

}
