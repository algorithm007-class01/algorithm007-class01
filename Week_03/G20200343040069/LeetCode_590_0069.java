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

        for(Node node : root.children){
            helper(node, res);
        }
        res.add(root.val);
    }

    // 2.iterative
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(null == root) return res;

        stack.add(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.push(node.val);
            for(Node item : node.children){
                if(item != null){
                    stack.push(item);
                }
            }
        }

        return res;
    }
}