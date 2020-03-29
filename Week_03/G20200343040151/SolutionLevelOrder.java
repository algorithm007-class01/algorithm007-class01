import java.util.ArrayList;
import java.util.List;

class SolutionLevelOrder {

    private List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> levelOrder(Node root) {
        if(root != null){
            recur(root,0);
        }
        return list;
    }
    public void recur(Node node,int level){
        if(list.size() <= level){
            list.add(new ArrayList());
        }

        list.get(level).add(node.val);

        for(Node element: node.children){
            recur(element,level+1);
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
    }






}
