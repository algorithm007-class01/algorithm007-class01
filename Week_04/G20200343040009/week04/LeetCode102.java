import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 创建二维数组接收每层的结点
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // 创建数组来接收出队的结点，存放的是每层的结点
            List<Integer> tmp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                // 定义node接收出队结点（即下一层级的父结点），然后加入数组tmp中
                TreeNode node = q.poll();
                tmp.add(node.val);
                // 如果有左右孩子，就一次入队、出队、进数组
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
