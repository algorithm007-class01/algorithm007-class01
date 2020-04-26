package com.szp.leetcode.q51_100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class A94_binary_tree_inorder_traversal {

//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if(null == root)
                return new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res =  new LinkedList<>();
            stack.push(root);
            TreeNode cur = root;
            while(!(cur==null && stack.isEmpty())){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }
    }
}
