package com.bai.week03.homework;

import java.util.*;

/**
 * @author Bai
 */
public class NAryTreePostorderTraversal {

    public static void main(String[] args) {
        Node1 node1 = initTree();

        List<Integer> values = postorder(node1);
        values.forEach(System.out::println);

        System.out.println("------------");
        System.out.println("------------");

        values.clear();
        iterationPostorder(node1, values);
        values.forEach(System.out::println);


    }

    public static List<Integer> postorder(Node1 root) {
        List<Integer> values = new ArrayList<>();
        recursivePostorder(root, values);
        return values;
    }

    /**
     * 递归方式
     */
    public static void recursivePostorder(Node1 root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        List<Node1> children = root.children;
        if (children != null) {
            for (Node1 child : children) {
                recursivePostorder(child, values);
            }
        }
    }

    public static void iterationPostorder(Node1 root, List<Integer> values) {
        if (root == null) return;
        List<Node1> currChildren = root.children;

        Deque<Node1> stack = new ArrayDeque<>();
        stack.push(root);
        values.add(root.val);

        while (!stack.isEmpty()) {
            // 有子节点继续深入，否则出栈
            while (currChildren != null && !currChildren.isEmpty()) {
                for (Node1 currNode1 : currChildren) {
                    values.add(currNode1.val);
                    stack.push(currNode1);
                }
                assert stack.peek() != null;
                currChildren = stack.pop().children;
            }
            // 没有则出栈
            if (!stack.isEmpty()) {
                currChildren = stack.pop().children;
            }
        }
    }


    public static Node1 initTree() {
        Node1 node1 = new Node1(1);
        Node1 node12 = new Node1(2);
        Node1 node13 = new Node1(3);
        Node1 node14 = new Node1(4);
        Node1 node15 = new Node1(5);
        Node1 node16 = new Node1(6);
        Node1 node17 = new Node1(7);
        Node1 node18 = new Node1(8);

        List<Node1> nodes1 = Arrays.asList(node13, node12, node14);
        List<Node1> nodes2 = Arrays.asList(node15, node16);
//        List<Node> nodes3 = Arrays.asList(node7, node8);

        node1.children = nodes1;
        node13.children = nodes2;


        return node1;
    }

}


// Definition for a Node.
class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
}