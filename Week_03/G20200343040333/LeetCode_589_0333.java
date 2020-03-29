package app;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_0333 {
    private List<Integer> list=null;
    public List<Integer> preorder(Node root) {
        list=new ArrayList<>();
        if(null==root) return list;
        list.add(root.val);
        beforeFind(root.children);
        return list;
    }
    private void beforeFind(List<Node> nodes){
        if(null==nodes) return ;
        for(Node node:nodes){
            if(null==node) continue;
            list.add(node.val);
            beforeFind(node.children);
        }
    }
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