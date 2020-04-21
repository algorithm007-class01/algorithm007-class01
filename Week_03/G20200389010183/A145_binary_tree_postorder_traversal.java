package com.szp.leetcode.q101_150;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class A145_binary_tree_postorder_traversal {
    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            if(null == root)
                return new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                res.add(0, cur.val);
                if(null != cur.left)
                    stack.push(cur.left);
                if(null != cur.right)
                    stack.push(cur.right);
            }
            return res;
        }
    }
}
