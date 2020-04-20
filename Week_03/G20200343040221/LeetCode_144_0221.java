import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (64.50%)
 * Likes:    228
 * Dislikes: 0
 * Total Accepted:    83K
 * Total Submissions: 128K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 基于栈的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) {
            if (null == root) {
                root = stack.pop();
            }

            while (null != root) {
                result.add(root.val);
                if (null != root.right) {
                    stack.push(root.right);
                }
                root = root.left;
            }
        }
        return result;
    }

    //递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        travel(root, result);
        return result;
    }

    private void travel(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        travel(root.left, result);
        travel(root.right, result);
    }
}
// @lc code=end

