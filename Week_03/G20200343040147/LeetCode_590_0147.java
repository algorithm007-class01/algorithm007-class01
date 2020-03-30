import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_0147 {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> r = new ArrayList<>();
        add(root, r);
        return r;
    }

    public void add(Node node, List<Integer> r) {
        if (node.children != null) {
            for (Node n : node.children) {
                add(n, r);
            }
        }
        r.add(node.val);
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};