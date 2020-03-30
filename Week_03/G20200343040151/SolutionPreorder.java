import java.util.ArrayList;
import java.util.List;

class SolutionPreorder {
    private List<Integer> list = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        recur(root);
        return list;
    }

    public void recur(TreeNode node){
        if(node == null){
            return;
        }

        list.add(node.val);
        recur(node.left);
        recur(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}