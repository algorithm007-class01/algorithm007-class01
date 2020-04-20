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
    public List<List<Integer>> levelOrder(TreeNode root) {
                if (root == null) {
            return Collections.emptyList();
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.pop();
                levelResult.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelResult);
        }
        return result;
    }
}