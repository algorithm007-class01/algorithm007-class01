import java.util.ArrayList;
import java.util.List;



class SolutionNTreePreOrder {

    private List<Integer> list = new ArrayList();
    public List<Integer> preorder(Node root) {
        recur(root);
        return list;
    }

    private void recur(Node node){
        if(node== null){
            return;
        }

        list.add(node.val);
        for(int i = 0;i < node.children.size();i++){
            recur(node.children.get(i));
        }
    }

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



}
