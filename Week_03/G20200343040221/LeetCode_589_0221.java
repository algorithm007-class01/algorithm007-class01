import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (72.39%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    21K
 * Total Submissions: 28.9K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
// Definition for a Node.
class Solution {
    // 基于栈的前序遍历
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);

            // 将下一个层级的节点全部入栈
            List<Node> children = node.children;
            if (null != children && children.size() > 0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    if (null != children.get(i)) {
                        stack.push(children.get(i));
                    }
                }
            }
        }
        return result;
    }

    // 基于递归
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        travel(root, result);
        return result;
    }
    private void travel(Node node, List<Integer> result) {
        if (null == node) {
            return;
        }
        result.add(node.val);

        List<Node> children = node.children;
        if (null != children && children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                travel(children.get(i), result);
            }
        }
    }
}
// @lc code=end

