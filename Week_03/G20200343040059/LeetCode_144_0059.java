import java.util.ArrayList;
import java.util.List;

public class _144_binary_tree_preorder_traversa {

    List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        // 定义返回结果集
        res = new ArrayList();

        // dfs,即 中-左-右
        dfs(root);

        return res;
    }

    // 递归方法
    public void dfs(TreeNode root) {

        if (null == root) {
            return;
        }

        // 中
        res.add(root.val);

        // 左
        if (null != root.left) {
            dfs(root.left);
        }

        // 右
        if (null != root.right) {
            dfs(root.right);
        }
    }

}
