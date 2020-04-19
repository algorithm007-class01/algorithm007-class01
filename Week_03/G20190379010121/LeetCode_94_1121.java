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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }

        inorderTraversal(res,root);
        return res;
    }
    private void inorderTraversal(List<Integer> res,TreeNode root){
        if(root == null){
            return ;
        }

        if(root.left != null){
            inorderTraversal(res,root.left);
        }
        res.add(root.val);
        if(root.right != null){
            inorderTraversal(res,root.right);
        }
    }

    //用栈模拟递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


}