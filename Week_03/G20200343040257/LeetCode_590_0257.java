package cxl.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class LeetCode_590_NAryTreePostorderTraversal {

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
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root,result);
        return result;
    }

    private void postOrderTraversal(Node node,List<Integer> result){
        if(node!=null){
            if(node.children!=null){
                for (Node child : node.children) {
                    postOrderTraversal(child,result);
                }
            }
            result.add(node.val);
        }
    }

}
