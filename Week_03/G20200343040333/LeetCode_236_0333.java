package app;
public class LeetCode_236_0333{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null==root||root==p||root==q) return root;
        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);
        //在左子树中没有找到，那一定在右子树中
        if(leftNode == null){
            return rightNode;
        }
        //在右子树中没有找到，那一定在左子树中
        if(rightNode == null){
            return leftNode;
        }
        //不在左子树，也不在右子树，那说明是根节点
        return root;
    }


    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}