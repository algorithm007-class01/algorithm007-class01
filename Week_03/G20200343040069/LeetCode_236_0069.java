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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return null == left ? right: null==right?left:root;
    }


    // 2.iterative using parent pointers Stack + Map + Set
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root, null);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (null != node.left) {
                stack.push(node.left);
                map.put(node.left, node);
            }
            if (null != node.right){
                stack.push(node.right);
                map.put(node.right, node);
            }
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        while (null != p){
            set.add(p);
            p = map.getOrDefault(p, null);
        }

        while ( null != q){
            if (set.contains(q)) return q;
            q = map.getOrDefault(q, null);
        }
        return null;
    }
}