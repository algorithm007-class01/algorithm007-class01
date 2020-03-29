package app;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_0333 {
    public List<List<Integer>> levelOrder(Node root) {
        if(null==root) return new ArrayList<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        getChildValues(root,list,1);
        
        return list;
    }
    private void getChildValues(Node root,List<List<Integer>> list,int level){
        
        if(list.size()<level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level-1).add(root.val);
        Node cur=root;
        if(null!=cur.children){
            List<Integer> listNewLevel=new ArrayList<>();
            
            for(Node node:cur.children){
                
                getChildValues(node,list,level+1);
            }
            
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