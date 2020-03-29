package week3.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * 说明:
 */
public class LeetCode_429_0227 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        //递归
//        return method1(root);
        //bfs
        return method2(root);
    }

    private List<List<Integer>> method2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ArrayList<Integer> curVal = new ArrayList<>();
            LinkedList<Node> curNode = new LinkedList<>();
            for (Node n : nodes) {
                curVal.add(n.val);
                curNode.addAll(n.children);
            }
            res.add(curVal);
            nodes = curNode;
        }
        return res;
    }

    //递归
    private List<List<Integer>> method1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, Node node, int level) {
        if (res.size() <= level) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        for (Node n : node.children) {
            helper(res, n, level + 1);
        }

    }
}
