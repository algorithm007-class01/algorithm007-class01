import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 */

public class LeetCode_590_0059 {

    List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList();
        dfs(root);
        return res;
    }

    public void dfs(Node root) {

        // 判断root结点是否为空
        if (null != root) {
            return;
        }

        for (Node node : root.children) {
            dfs(node);
        }
        res.add(root.val);
    }

}

