package com.szp.leetcode.q101_150;

import com.szp.leetcode.common.TreeNode;

public class A111_minimum_depth_of_binary_tree {
    class Solution {
        public int minDepth(TreeNode root) {
            if(null == root)
                return 0;
            if(root.left == null)
                return minDepth(root.right) + 1;
            if(root.right == null)
                return minDepth(root.left) + 1;
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }
}
