import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_0147 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> r = new ArrayList<>();
        add(root, r);
        return r;
    }

    public void add(TreeNode cur, List<Integer> r) {
        r.add(cur.val);
        if (cur.left != null) {
            add(cur.left, r);
        }
        if (cur.right != null) {
            add(cur.right, r);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
