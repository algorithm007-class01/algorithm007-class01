package week3.homework;

import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode_144_0227 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //递归
//        return method1(root);
        //迭代
        return method2(root);
    }

    //前序遍历先输出根节点
    private List<Integer> method2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.pollLast();
            res.add(node.val);
            if (node.right!=null){
                list.add(node.right);
            }
            if (node.left!=null){
                list.add(node.left);
            }

        }
        return res;
    }

    private List<Integer> method1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        if (node.left != null) helper(res, node.left);
        if (node.left != null) helper(res, node.right);
    }

}
