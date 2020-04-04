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
        Stack<TreeNode> store = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null || !store.isEmpty()) {
            // 找到当前节点最左侧的节点
            while (current != null) {
                store.push(current);
                current = current.left;
            }
            current = store.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}