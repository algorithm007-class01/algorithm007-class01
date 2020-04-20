/*
 * @lc app=leetcode.cn id=144 lang=csharp
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start

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
    /// <summary>
    /// 迭代法
    /// </summary>
    /// <param name="root"></param>
    /// <returns></returns>
    public IList<int> PreorderTraversal(TreeNode root) {
        List<int> res = new List<int>();
        if (root != null)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.Push(root);
            while (stack.Count > 0)
            {
                TreeNode node = stack.Pop();
                res.Add(node.val);
                if (node.right != null)
                {
                    stack.Push(node.right);
                }
                if (node.left != null)
                {
                    stack.Push(node.left);
                }
            }
        }
        return res;
    }
}
// @lc code=end

