package com.szp.leetcode.q201_250;

import java.util.ArrayList;

public class A226_invert_binary_tree {

    //     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (null == root || (root.left == null && root.right == null))
                return root;
            invertTree(root.left);
            invertTree(root.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            return root;
        }
    }
}
