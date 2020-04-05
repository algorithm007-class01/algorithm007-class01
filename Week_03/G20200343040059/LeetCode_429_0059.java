import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 */
public class _429_n_ary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder(Node root) {
        // 1.利用队列进行广度优先搜索
        List<List<Integer>> res = new ArrayList();
        if (null == root) {
            return res;
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            for (int i = 0; i < queue.size(); i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }

}
