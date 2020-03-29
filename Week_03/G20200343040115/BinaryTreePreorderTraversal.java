//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
//        Solution solution = new BinaryTreePreorderTraversal().new Solution();
//        TreeNode<Integer>node3=new TreeNode<>(3);
//        TreeNode<Integer>node4=new TreeNode<>(4);
//        TreeNode<Integer>node5=new TreeNode<>(6);
//        TreeNode<Integer>node2=new TreeNode<>(2);
//        TreeNode<Integer> node1=new TreeNode<Integer>(1);
//        node1.left=node4;
//        node1.right=node2;
//        node2.left=node3;
//        node2.right=node5;
//        List<Integer>list=new ArrayList<>();
//        list=solution.preorderTraversal(node1);
//        for(int i:list){
//            System.out.printf(" "+i);
//        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack=new LinkedList<>();
            LinkedList<Integer> res=new LinkedList<>();
            if(root!=null)stack.add(root);
            while (!stack.isEmpty()){
                TreeNode node=stack.pollLast();
                res.add(node.val);
                if(node.right!=null){
                    stack.add(node.right);
                }
                if(node.left!=null){
                    stack.add(node.left);
                }

            }
            return res;
        }



    }
   class TreeNode<E>{
        int val;
        TreeNode<E> left;
        TreeNode<E>right;
        TreeNode(int x){val=x;}
    }
//leetcode submit region end(Prohibit modification and deletion)

}