package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_0223 {

    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        helper(root);
        return result;
    }

    void helper(Node root){
        if(root == null) return;
        result.add(root.val);
        for(Node child : root.children){
            helper(child);
        }
    }

    // Definition for a Node.
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
}
