package com.studyWeek3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 */
public class LeetCode589 {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            stack.addAll(node.children);
        }
        return output;
    }
}
