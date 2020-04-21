package com.szp.leetcode.q551_600;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class A589_n_ary_tree_preorder_traversal {

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

    class Solution {
        public List<Integer> postorder(Node root) {
            if(null == root)
                return new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            List<Integer> res = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node n = stack.pop();
                res.add(n.val);
                if(n.children == null)
                    continue;
                for (int i = n.children.size()-1; i >= 0; i--) {

                    stack.push(n.children.get(i));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A589_n_ary_tree_preorder_traversal().new Solution();
        Node node = new A589_n_ary_tree_preorder_traversal().new Node(1);
        Node node1 = new A589_n_ary_tree_preorder_traversal().new Node(2);
        Node node2 = new A589_n_ary_tree_preorder_traversal().new Node(3);
        Node node3 = new A589_n_ary_tree_preorder_traversal().new Node(4);
        List<Node> c1 = new LinkedList<>();
        c1.add(node1);
        c1.add(node2);
        c1.add(node3);
        node.children = c1;
        Node node4 = new A589_n_ary_tree_preorder_traversal().new Node(5);
        Node node5 = new A589_n_ary_tree_preorder_traversal().new Node(6);
        List<Node> c2 = new LinkedList<>();
        c2.add(node4);
        c2.add(node5);
        node1.children = c2;
        Node node6 = new A589_n_ary_tree_preorder_traversal().new Node(7);
        Node node7 = new A589_n_ary_tree_preorder_traversal().new Node(8);
        List<Node> c3 = new LinkedList<>();
        c3.add(node6);
        c3.add(node7);
        node2.children = c3;
        Node node8 = new A589_n_ary_tree_preorder_traversal().new Node(9);
        List<Node> c4 = new LinkedList<>();
        c4.add(node8);
        node3.children = c4;

        solution.postorder(node).forEach(System.out::println);
    }
}
