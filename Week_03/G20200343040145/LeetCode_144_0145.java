import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树的前序遍历
 * */
public class LeetCode_144_0145 {

    /**
     *
     *  前序遍历的顺序是 ： 根节点 左节点 、右节点
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode last = stack.pollLast();
            list.add(last.val);
            /*
            *  栈的结构是先入后出
            *  先压右节点，后压左节点
            *  左节点先出 、 右节点后出 符合 根、左、右的要求
            * */
            if (last.right != null) {
                stack.add(last.right);
            }
            if (last.left != null) {
                stack.add(last.left);
            }
        }
        return list;
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

