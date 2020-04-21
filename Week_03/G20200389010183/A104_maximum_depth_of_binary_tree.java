package com.szp.leetcode.q101_150;

import com.szp.leetcode.common.TreeNode;

public class A104_maximum_depth_of_binary_tree {
    //     Definition for a binary tree node.

    class Solution {
        public int maxDepth(TreeNode root) {
            if(null == root)
                return 0;
            if(root.left == null && root.right == null)
                return 1;
            return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
        }
    }
}
