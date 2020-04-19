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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        preorder(res,root);
        return res;
    }
    private void preorder(List<Integer> res,Node root){
        if(root == null){
            return ;
        }
        res.add(root.val);
        if(root.children != null){
            for(Node node : root.children){
                preorder(res,node);
            }
        }
    }
}