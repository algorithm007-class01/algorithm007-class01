package com.szp.leetcode.q101_150;

import com.szp.leetcode.common.TreeNode;

public class A105_construct_binary_tree_from_preorder_and_inorder_traversal {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (null == preorder || preorder.length == 0)
                return null;
            if (preorder.length == 1)
                return new TreeNode(preorder[0]);
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
            if(pStart >= pEnd)
                return null;
            int rootVal = preorder[pStart];
            int index = findRootNode(inorder, iStart, iEnd, rootVal);
            TreeNode node = new TreeNode(rootVal);
            int leftLen = index - iStart;
            int rightLen = iEnd - index;
            node.left = buildTree(preorder, pStart + 1, pStart + 1 + leftLen, inorder, iStart, index);
            node.right = buildTree(preorder, pStart + 1 + leftLen, pEnd, inorder, index + 1, iEnd);
            return node;
        }

        private int findRootNode(int[] inorder, int iStart, int iEnd, int target) {
            for (int i = iStart; i < iEnd; i++) {
                if (inorder[i] == target)
                    return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A105_construct_binary_tree_from_preorder_and_inorder_traversal().new Solution();
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(pre, in);
        System.out.println(treeNode.printLevelOrder());
        System.out.println(treeNode.printPreOrder());
        System.out.println(treeNode.printInOrder());
        System.out.println(treeNode.printPostOrder());
    }
}
