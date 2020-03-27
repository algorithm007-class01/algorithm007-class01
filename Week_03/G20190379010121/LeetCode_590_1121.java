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
    public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<Integer>();
            if(root == null){
                return res;
            }
        postorder(res,root);
        return res;
    }
    private void postorder(List<Integer> res,Node root){
        if(root == null){
            return;
        }
        if(root.children != null){
            for(Node node : root.children){
                postorder(res,node);
            }
        }
        res.add(root.val);
    }
}