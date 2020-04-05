import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (72.41%)
 * Likes:    57
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 25.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
class Solution {
    // 基于栈和链表
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 将新节点的值放在链表的头部，层级越靠上的节点越早被放入链表，在链表中处于靠后的位置。
            Node node = stack.pop();
            result.addFirst(node.val);

            // 将下一层级的节点入栈
            List<Node> children = node.children;
            if (null != children && children.size() > 0) {
                for (int i = 0; i < children.size(); i++) {
                    Node child = children.get(i);
                    if (null != child) {
                        stack.push(child);
                    }
                }
            }
        }

        return result;
    }

    // 基于递归
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        travel(root, result);
        return result;
    }
    private void travel(Node node, List<Integer> result) {
        if (null == node) {
            return;
        }
        List<Node> children = node.children;
        if (null != children && children.size() > 0) {
            for (Node child : children) {
                travel(child, result);
            }
        }
        result.add(node.val);
    }
}
// @lc code=end

