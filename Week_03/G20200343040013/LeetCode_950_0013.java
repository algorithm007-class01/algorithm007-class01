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
public List<Integer> postOrder(Node root) {
    List<Integer> list = new ArrayList();

    helper(root, list);
    return list;
}

private void helper(Node node, list) {
    if( node == null) {
        return;
    }

    List<Node> children = node.children;

    for(Node node1 : children) {
        if(node1 != null) {
            helper(node1, list);
        }
    }
    list.add(node.val);
}