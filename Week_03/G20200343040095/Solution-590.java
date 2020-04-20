import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }

        return res;
    }
}
// @lc code=end

