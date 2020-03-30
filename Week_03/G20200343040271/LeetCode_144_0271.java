/*
144. 二叉树的前序遍历
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
给定一个二叉树，返回它的 前序 遍历。
*/
public class BinaryTreePreorderTraversal {

    /**
     * 方法一：迭代 + 栈
     * 效率比递归低下
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }


    /**
     * 方法二：递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderifyDown(root, res);
        return res;
    }
    private void preorderifyDown(TreeNode root, List<Integer> res) {
        if(root != null){
            res.add(root.val);
            if (root.left != null){
                preorderifyDown(root.left, res);
            }
            if(root.right != null){
                preorderifyDown(root.right, res);
            }
        }
    }
}
