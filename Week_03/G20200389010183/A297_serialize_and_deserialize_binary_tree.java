package com.szp.leetcode.q251_300;

import com.sun.source.tree.Tree;
import com.szp.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A297_serialize_and_deserialize_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(null == root)
                return "null";
            StringBuilder stringBuilder = new StringBuilder();
            List<TreeNode> level = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            level.add(root);
            sb.append(root.val);
            while(!level.isEmpty()){
                sb.append(",");
                int len = level.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = level.remove(0);
                    if(node.left != null){
                        level.add(node.left);
                        if(i==0)
                            sb.append(node.left.val);
                        else
                            sb.append("#" + node.left.val);
                    }else{
                        if(i==0)
                            sb.append("null");
                        else
                            sb.append("#null");
                    }
                    if(node.right != null){
                        level.add(node.right);
                        sb.append("#" + node.right.val);
                    }else{
                        sb.append("#null");
                    }
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("null".equals(data))
                return null;
            String[] levels = data.split(",");
            Queue<TreeNode> queue=new LinkedList(); //辅助队列
            TreeNode root = new TreeNode(Integer.parseInt(levels[0]));
            queue.add(root);
            for (int i = 1; i < levels.length; i++) {
                String[] values = levels[i].split("#");
                for (int j = 0; j < values.length; j+=2) {
                    TreeNode node = queue.poll();
                    String left = values[j];
                    String right = values[j+1];
                    if(!"null".equals(left)){
                        node.left = new TreeNode(Integer.parseInt(left));
                        queue.add(node.left);
                    }
                    if(!"null".equals(right)) {
                        node.right = new TreeNode(Integer.parseInt(right));
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }
    }


    // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
    public static void main(String[] args) {
        Codec codec = new A297_serialize_and_deserialize_binary_tree().new Codec();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        String s = codec.serialize(treeNode1);
        System.out.println(s);
        TreeNode treeNode = codec.deserialize(s);
        System.out.println(treeNode.printLevelOrder());
        System.out.println(treeNode.printPreOrder());
        System.out.println(treeNode.printInOrder());
        System.out.println(treeNode.printPostOrder());
    }
}
