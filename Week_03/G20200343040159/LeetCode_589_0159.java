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

/**
* 589. N叉树的前序遍历 <p>
* https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
*
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> postorder = new ArrayList();

        if(null==root){
             return postorder;
        }else if(root.children==null){
            postorder.add(root.val);
            return postorder;
        }else{
            postorder.add(root.val);
            for(Node n: root.children){
                postorder.addAll(preorder(n));
            }
            return postorder;
        }
    }
}