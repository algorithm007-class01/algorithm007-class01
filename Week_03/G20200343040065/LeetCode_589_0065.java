package leetCode.week03;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_589_0065 {
	
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
		
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Integer> res = new LinkedList<>();
		
		if(root == null)
            return res;
		
		stack.addFirst(root);
		
        while (stack.size() > 0) {
        	Node nd = stack.pollLast();
        	res.add(nd.val);
        	for (Node node : nd.children) {
        		if(node != null) {
        			stack.add(node);
        		}
        	}
        }
        
        return res;
    }
}
