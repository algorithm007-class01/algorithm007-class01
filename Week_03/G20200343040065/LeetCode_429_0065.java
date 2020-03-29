package leetCode.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_429_0065 {
	
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
	
	public List<List<Integer>> levelOrder(Node root) {
		
		if (root == null)
			return new ArrayList<>();
			
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
        	List<Integer> level = new ArrayList<>();
        	int size = queue.size();
        	
        	for (int i = 0;i < size;i++) {
        		Node node = queue.poll();
        		level.add(node.val);
        		if (node.children != null)
        			queue.addAll(node.children);
        	}
        	res.add(level);
        }
		return res;
        
    }
}
