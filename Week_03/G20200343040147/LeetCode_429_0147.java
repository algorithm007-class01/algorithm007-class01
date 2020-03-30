import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode_429_0147 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> r = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.pollFirst();
                l.add(cur.val);
                if (cur.children != null) {
                    for (Node n : cur.children) {
                        queue.addLast(n);
                    }
                }
            }
            r.add(l);
        }
        return r;
    }
}
