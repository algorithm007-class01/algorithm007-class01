package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_0223 {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return result;
        helper(root,0);
        return result;
    }

    void helper(Node root,int level){
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for(Node child : root.children){
            helper(child,level+1);
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
