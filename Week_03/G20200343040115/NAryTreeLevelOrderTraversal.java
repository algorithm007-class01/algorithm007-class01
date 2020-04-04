//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        Node node1=new NAryTreeLevelOrderTraversal().new Node(1);
        Node node2=new NAryTreeLevelOrderTraversal().new Node(2);
        Node node3=new NAryTreeLevelOrderTraversal().new Node(3);
        Node node4=new NAryTreeLevelOrderTraversal().new Node(4);
        Node node5=new NAryTreeLevelOrderTraversal().new Node(5);
        Node node6=new NAryTreeLevelOrderTraversal().new Node(6);
        List<Node> list=new ArrayList<>();
        list.add(null);
        list.add(node3);list.add(node2);list.add(node4);list.add(null);
        node1.children=list;
        List<Node> li=new ArrayList<>();
        li.add(node5);li.add(node6);
        node3.children=li;
        List<List<Integer>> lists=new ArrayList<>();
        lists=solution.levelOrder(node1);
        for(List<Integer> i:lists){
           for (int j:i){
               System.out.printf(" "+j);
           }
            System.out.println();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
           List<List<Integer>>res=new ArrayList<>();
           if(root==null)return res ;
           Queue<Node> queue=new LinkedList<>();
           queue.add(root);
           while (!queue.isEmpty()){
               List<Integer> level=new ArrayList<>();
               int size=queue.size();
               for(int i=0;i<size;i++){
                   Node node=queue.poll();
                   level.add(node.val);
                   queue.addAll(node.children);

               }
               res.add(level);
           }
           return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
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

}