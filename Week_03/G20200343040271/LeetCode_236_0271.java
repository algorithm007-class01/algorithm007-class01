/*
236. 二叉树的最近公共祖先
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
*/
public class LowestCommonAncestorOfABinaryTree {
    private TreeNode ansNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //findAncestor1(root, p, q);
        //return ansNode;
        return findAncestor(root, p, q);
    }

    /**
     * 递归：
     * 思路，
     * 如果当前节点p 或者 q 相同，则返回当前节点
     * 分别遍历左右子树，如果左子树为空，那结果集在右子树上，如果右子树为空，则结果集在左子树上
     * 如果左右子树都不为空，那说明当前节点即为所求
     * @param currNode
     * @param p
     * @param q
     * @return
     */
    private TreeNode findAncestor(TreeNode currNode, TreeNode p, TreeNode q) {
        if(currNode == null) return null;
        if(currNode == p || currNode == q){
            return currNode;
        }
        TreeNode left = findAncestor(currNode.left, p, q);
        TreeNode right = findAncestor(currNode.right, p, q);

        if(left == null) {
            return right;
        }
        if(right == null){
            return left;
        }
        if(left != null && right != null){
            return currNode;
        }

        return null;
    }

    /**
     * 方法一：递归
     * @param currNode
     * @param p
     * @param q
     * @return
     */
    private boolean findAncestor1(TreeNode currNode, TreeNode p, TreeNode q) {
        if(currNode == null) return false;
        int left = findAncestor1(currNode.left, p, q)?1:0;
        int right = findAncestor1(currNode.right, p, q)?1:0;
        int mid = (currNode == p || currNode == q)? 1:0;
        if(mid + left + right >= 2) ansNode = currNode;
        return (mid + left + right) > 0;
    }
}