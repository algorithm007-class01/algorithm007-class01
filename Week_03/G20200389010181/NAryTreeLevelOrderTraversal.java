package com.bai.week03.homework;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bai
 */
public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Node node = initTree();
//        List<List<Integer>> values = new ArrayList<>();
//        recursive(node, values, 0);
        List<List<Integer>> values = userQueue(node);
        values.forEach(System.out::println);
    }


    public static Node initTree() {
        Node node1 = new Node(1);
        Node node12 = new Node(2);
        Node node13 = new Node(3);
        Node node14 = new Node(4);
        Node node15 = new Node(5);
        Node node16 = new Node(6);
        Node node17 = new Node(7);
        Node node18 = new Node(8);

        List<Node> nodes1 = Arrays.asList(node13, node12, node14);
        List<Node> nodes2 = Arrays.asList(node15, node16);
//        List<Node> nodes3 = Arrays.asList(node7, node8);

        node1.children = nodes1;
        node13.children = nodes2;


        return node1;
    }

    public List<List<Integer>> levelOrder(Node node) {
        List<List<Integer>> values = new ArrayList<>();
        if (node == null) return values;
        // set values
        List<Node> subList = new ArrayList<>();
        subList.add(node);
        while (!subList.isEmpty()) {
            List<Integer> subValues = new ArrayList<>();
            List<Node> nextSubList = new ArrayList<>();
            for (Node n : subList) {
                subValues.add(n.val);
                nextSubList.addAll(n.children);
            }
            values.add(subValues);
            subList = nextSubList;
        }
        return values;
    }

    // java8 stream
    private void setValues(List<List<Integer>> values, List<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Integer> currValues = new ArrayList<>();
        List<Node> currNodes = new ArrayList<>();
        nodes.forEach(node -> {
            currValues.add(node.val);
            if (node.children != null) {
                currNodes.addAll(node.children);
            }
        });
        values.add(currValues);
        setValues(values, currNodes);
    }

    // normal
    private void normalSetValues(List<List<Integer>> values, List<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Integer> currValues = new ArrayList<>();
        List<Node> currNodes = new ArrayList<>();
        for (Node node : nodes) {
            currValues.add(node.val);
            if (node.children != null) {
                currNodes.addAll(node.children);
            }
        }
        values.add(currValues);
        setValues(values, currNodes);
    }

    // recursive
    public static void recursive(Node node, List<List<Integer>> values, int floor) {
        if (values.size() > floor) {
            values.get(floor).add(node.val);
        } else {
            List<Integer> currValues = new ArrayList<>();
            currValues.add(node.val);
            values.add(floor, currValues);
        }
        if (node.children != null) {
            floor++;
            for (Node child : node.children) {
                recursive(child, values, floor);
            }
        }
    }


    public static List<List<Integer>> userQueue(Node root) {
        List<List<Integer>> values = new ArrayList<>();

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subValues = new ArrayList<>();
            Deque<Node> currQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                Node first = queue.remove();
                subValues.add(first.val);
                if (first.children != null) {
                    currQueue.addAll(first.children);
                }
            }
            values.add(subValues);
            queue = currQueue;
        }
        return values;
    }


}


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