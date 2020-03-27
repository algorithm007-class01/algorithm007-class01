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
题目：给定一个 N 叉树，返回其节点值的前序遍历。

第一种解法：递归

前序遍历：根左右

执行时间：0 ms

个人感受：
    官方嫌太简单，居然都不写解答了。。。
    前序遍历的时候，要先把根节点加入最后的输出 list 中。
*/
class Solution {
    private LinkedList<Integer> result = new LinkedList<Integer>();

    public List<Integer> preorder(Node root) {
        helper(root);
        return result;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        for (Node item : root.children) {
            helper(item);
        }
    }
}