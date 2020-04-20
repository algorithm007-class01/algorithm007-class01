import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_589_0241 {

    /*给定一个 N 叉树，返回其节点值的后序遍历。 */

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
     * 递归方法
     */
    class SolutionOne {
        public List<Integer> preorder(Node root) {
            List<Integer> target = new ArrayList<>();
            preOrder(root, target);
            return target;
        }

        public void preOrder(Node node, List<Integer> target) {
            if (node != null) {
                target.add(node.val);
                for (Node node1 : node.children) {
                    preOrder(node1, target);
                }
            }
        }
    }

    /**
     * 迭代法
     * 时间复杂度：O(M)
     * 空间复杂度：O(M) M是N叉树中的节点个数
     */
    class SolutionTwo {
        public List<Integer> preorder(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                output.add(node.val);
                Collections.reverse(node.children);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
            return output;
        }
    }
}