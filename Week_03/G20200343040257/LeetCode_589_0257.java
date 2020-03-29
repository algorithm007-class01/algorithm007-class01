package cxl.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class LeetCode_589_NAryTreePreorderTraversal {

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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root,result);
        return result;
    }

    private void preOrderTraversal(Node node,List<Integer> result){
        if(node !=null){
            result.add(node.val);
            for (Node child : node.children) {
                preOrderTraversal(child,result);
            }
        }
    }

}
