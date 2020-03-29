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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root,pre);
        return pre;
    }
    public void preHelper(TreeNode root, List<Integer> pre) {
        if(root==null) return;
        pre.add(root.val);
        preHelper(root.left,pre);
        preHelper(root.right,pre);
    }
}