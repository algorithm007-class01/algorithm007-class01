/*
 * @lc app=leetcode.cn id=105 lang=csharp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

using System;
using System.Collections.Generic;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int index = 0;
    private int[] _preorder;
    private int[] _inorder;
    private Dictionary<int, int> dic = new Dictionary<int, int> ();

    /// <summary>
    /// 递归
    /// </summary>
    /// <param name="preorder"></param>
    /// <param name="inorder"></param>
    /// <returns></returns>
    public TreeNode BuildTree (int[] preorder, int[] inorder) {
        _preorder = preorder;
        _inorder = inorder;
        for (int i = 0; i < inorder.Length; i++) {
            dic[inorder[i]] = i;
        }
        return recursive (0, preorder.Length);
    }

    private TreeNode recursive (int left, int right) {
        if (left == right) {
            return null;
        }

        int val = _preorder[index++];
        TreeNode root = new TreeNode (val);

        int idx = dic[val];
        root.left = recursive (left, idx);
        root.right = recursive (idx + 1, right);
        return root;
    }
}
// @lc code=end