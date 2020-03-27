import java.util.LinkedList;
import java.util.List;

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

题目：给定一个 N 叉树，返回其节点值的后序遍历。

第一种解法：递归

后序遍历：左右根

执行时间：0 ms

个人感受：
    相比前序遍历，后序遍历最后加入根结点。
*/
class Solution {
    private LinkedList<Integer> result = new LinkedList<Integer>();

    public List<Integer> postorder(Node root) {
        helper(root);
        return result;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }

        for (Node item : root.children) {
            helper(item);
        }
        result.add(root.val);
    }
}