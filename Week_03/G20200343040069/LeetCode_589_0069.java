/*
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
};
*/
class Solution {

    // 1.recursion
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res){
        if(null == root) return;

        res.add(root.val);
        for(Node node : root.children){
            helper(node, res);
        }
    }

    // 2.iterative
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if(null == root) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.poll();
            res.add(node.val);
            int n = node.children.size();
            for(int i = n-1; i >= 0; i--){
                stack.push(node.children.get(i));
            }

        }
        return res;
    }
}