public class LeetCode_641_0241 {

    /*给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 */

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 迭代法
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    class Solution {

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.val);
                    queue.addAll(node.children);
                }
                result.add(level);
            }
            return result;
        }
    }


