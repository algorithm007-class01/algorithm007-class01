package com.lester.work;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_week03_0205 {

    static class SolutionTree {
        public List<Integer> inorderTraversal(com.lester.work.SolutionTree.TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        public void helper(com.lester.work.SolutionTree.TreeNode root, List<Integer> res) {
            if (root != null) {
                if (root.left != null) {
                    helper(root.left, res);
                }
                res.add(root.val);
                if (root.right != null) {
                    helper(root.right, res);
                }
            }
        }

        public class TreeNode {
            public int val;
            public com.lester.work.SolutionTree.TreeNode left, right;

            public TreeNode(int val) {
                this.val = val;
                this.left = null;
                this.right = null;
            }
        }

        public class Node {
            public int val;
            public List<com.lester.work.SolutionTree.Node> children;

            public Node(int val) {
                this.val = val;
                this.children = null;
            }
        }

        public List<Integer> postorder(com.lester.work.SolutionTree.Node root) {
            LinkedList<com.lester.work.SolutionTree.Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                com.lester.work.SolutionTree.Node node = stack.pollLast();
                output.addFirst(node.val);
                for (com.lester.work.SolutionTree.Node item : node.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }
            }
            return output;
        }


        public List<Integer> preorderTraversal(com.lester.work.SolutionTree.TreeNode root) {
            LinkedList<com.lester.work.SolutionTree.TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                com.lester.work.SolutionTree.TreeNode node = stack.pollLast();
                output.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }
    }

    private static ArrayList<String> result;


    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(0, 0, n, "");
        return result;
    }

    private static void generate(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            //filter the invalid s
            System.out.println(s);
            result.add(s);
            return;
        }
        //process

        //drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
        //reverse states
    }

    public static void main(String[] args) {
        /**
         * left 随时可以加  只要别超标
         * right 必须之前有左括号 且左个数 > 右个数
         */
        System.out.println(generateParenthesis(3));
    }

}


