package com.bai.week03.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Bai
 */
public class BinaryTreePreorderTraversal {


    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>();

    }

    public void recursivePreorder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        TreeNode left = root.left;
        recursivePreorder(left, values);
        TreeNode right = root.right;
        recursivePreorder(right, values);
    }

    public void iterationPreorder(TreeNode root, List<Integer> values) {
        if (root == null) return;;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                values.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
