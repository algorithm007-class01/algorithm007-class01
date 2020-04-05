import java.util.ArrayList;
import java.util.List;

public class _589n_ary_tree_preorder_traversal {

    List<Integer> res;

    public List<Integer> preorder(Node root) {
        res = new ArrayList();
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (null == root) {
            return;
        }

        res.add(root.val);
        for (Node node : root.children) {
            dfs(node);
        }
    }
}
