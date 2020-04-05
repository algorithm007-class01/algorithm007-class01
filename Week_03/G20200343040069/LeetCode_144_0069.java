/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1.recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res){
        if(null == root) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    // 2.iterative
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr!= null || !stack.isEmpty()){
            while(curr != null){
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }
}