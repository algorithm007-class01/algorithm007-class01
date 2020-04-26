package week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l102erChaShuCengCiBianLi {

    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9);
        TreeNode root = new TreeNode(20, t9, t20);
        List<List<Integer>> lists = new Solution().leverOrder(root);
        System.out.println(lists);

    }

    static public class Solution {
        public List<List<Integer>> leverOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<>();
            if (root == null) return levels;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                levels.add(new ArrayList<>());
                int levelLength = queue.size();
                for (int i = 0; i < levelLength; i++) {
                    TreeNode node = queue.remove();
                    levels.get(level).add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                level ++;
            }
            return levels;
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
