public class LeetCode_641_0241 {

    /*给定一个二叉树，返回它的 前序 遍历。 */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归方法
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> target = new ArrayList<>();
            preOrder(root,target);
            return target;
        }

        public void preOrder(TreeNode node,List<Integer> target){
            if(node == null) return;
            target.add(node.val);
            preOrder(node.left,target);
            preOrder(node.right,target);
        }
    }

    /**
     * 迭代法
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
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
    }

