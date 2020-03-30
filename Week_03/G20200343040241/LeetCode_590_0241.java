public class LeetCode_641_0241 {

    /*给定一个 N 叉树，返回其节点值的后序遍历。 */
    /**
     * 递归方法
     */
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> target = new ArrayList<>();
            postOrder(root,target);
            return target;
        }

        public void postOrder(Node node,List<Integer> target){
            if(node != null) {
                for(Node node1:node.children){
                    postOrder(node1,target);
                }
                target.add(node.val);
            }
        }
    }

    /**
     * 迭代法
     * 时间复杂度：O(M)
     * 空间复杂度：O(M) M是N叉树中的节点个数
     */
    class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                output.addFirst(node.val);
                for (Node item : node.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }
            }
            return output;
        }
    }
}
