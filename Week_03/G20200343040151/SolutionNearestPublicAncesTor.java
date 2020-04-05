
class SolutionNearestPublicAncesTor {

    private TreeNode ancesTorNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root,p,q);
        return ancesTorNode;
    }

    public boolean recur(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }

        int left = 0;
        boolean isleft = recur(node.left,p,q);
        left = isleft ? 1:0;

        int right = 0;
        boolean isright = recur(node.right,p,q);
        right = isright ? 1:0;

        int current = 0;
        if(node == p || node == q){
            current = 1;
        }

        if(left + right + current >=2){
            this.ancesTorNode = node;
            return true;
        }

        return (left + right+current >0 );
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

//root ?= p
// left ?= p
//right ?= q




//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || p == root || q == root) {
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left == null) {
//            return right;
//        }
//        if (right == null) {
//            return left;
//        }
//        return root;
//    }
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
//}

