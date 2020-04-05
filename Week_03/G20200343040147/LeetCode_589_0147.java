import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_0147 {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> r = new ArrayList<>();
        add(root, r);
        return r;
    }

    public void add(Node root, List<Integer> r) {
        r.add(root.val);
        for (Node n : root.children) {
            add(n, r);
        }
    }


}