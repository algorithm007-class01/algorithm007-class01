package com.szp.leetcode.q51_100;

import com.szp.leetcode.common.TreeNode;

public class A98_validate_binary_search_tree {



    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        }

        public boolean isValidBST(TreeNode node, long low, long high) {
            if (null == node)
                return true;
            int curVal = node.val;
            if (curVal <= low || curVal >= high)
                return false;
            return isValidBST(node.left, low, curVal) &&
                    isValidBST(node.right, curVal, high);
        }
    }
}
