import java.util.ArrayList;
import java.util.List;

class SolutionPostOrder {
    public  List<Integer> list = new ArrayList();
    public List<Integer> postorder(Node root) {
        recur(root);
        return list;

    }

    public void recur(Node node){
        if(node == null ){
            return;
        }

        for(int i = 0;i < node.children.size();i++){
            recur(node.children.get(i));
        }

        list.add(node.val);
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