package app;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_0333{
    //recursion
    List<Integer> list=null;
    public List<Integer> postorder(Node root) {
        list=new ArrayList<>();
        if(null!=root){
            
            afterSearch(root.children);
            list.add(root.val);
        }
        return list;
    }
    //recursion after find
    private void afterSearch(List<Node> nodes){
        if(null==nodes) return ;
        for(Node node:nodes){
            if(null==node) continue;
            afterSearch(node.children);
            list.add(node.val);
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