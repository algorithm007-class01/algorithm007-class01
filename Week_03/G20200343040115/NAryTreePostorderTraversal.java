//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();

        Node node1=new NAryTreePostorderTraversal().new Node(1);
        Node node2=new NAryTreePostorderTraversal().new Node(2);
        Node node3=new NAryTreePostorderTraversal().new Node(3);
        Node node4=new NAryTreePostorderTraversal().new Node(4);
        Node node5=new NAryTreePostorderTraversal().new Node(5);
        Node node6=new NAryTreePostorderTraversal().new Node(6);
        List<Node> list1=new ArrayList<>();
        list1.add(node2);list1.add(node3);list1.add(node4);
        List<Node> list2=new ArrayList<>();
        list2.add(node5);list2.add(node6);
        node1.children=list1;
        node2.children=list2;
        List<Integer> res=new ArrayList<>();
       res= solution.postorder(node1);
        for(int i:res){
            System.out.print(" i="+i);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//}

    class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                output.addFirst(node.val);
                if(node.children!=null){
                for (Node item : node.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }}
            }

            return output;


        }
    }

//leetcode submit region end(Prohibit modification and deletion)
class Node{
    int val;
    List<Node>children;
    public Node(){}
    public Node(int _val){val=_val;}
    public Node(int _val,List<Node>children){
        val=_val;
        this.children=children;
    }
}

}