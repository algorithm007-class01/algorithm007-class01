import java.util.*;

public class LeetCode_236_0147 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode,TreeNode> map = new HashMap<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode t = queue.pollFirst();
            if (t.left!=null){
                queue.addLast(t.left);
                map.put(t.left,t);
            }
            if (t.right!=null){
                queue.addLast(t.right);
                map.put(t.right,t);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p = map.get(p);
        }

        while (!set.contains(q)){
            q = map.get(q);
        }

        return q;
    }
}
