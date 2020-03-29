import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 二叉树 后续遍历
 *
 * 1. 递归，方法简单
 * 2. 循环
 * */
public class LeetCode_590_0145 {

    // 第一种方法 递归,非题目要求的方法
    public List<Integer> postorderRecursion(Node root) {

        ArrayList<Integer> res = new ArrayList<>();
        recursionPostOrder(root, res);
        return res;
    }
    // 承接第一个方法
    private void recursionPostOrder(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            recursionPostOrder(ch, res);
        }
        res.add(root.val);
    }

    /**
     * 第二种方法:循环
     */

    public List<Integer> postorderIterator(Node root) {
        LinkedList res = new LinkedList();
        LinkedList<Node> stak = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stak.add(root);
        while (!stak.isEmpty()) {
            Node last = stak.pollLast();
            res.addFirst(last.val);
            for (Node chNode : last.children) {
                stak.add(chNode);
            }
        }
        return res;
    }


}

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