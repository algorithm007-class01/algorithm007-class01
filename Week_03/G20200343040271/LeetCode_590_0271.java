//590. N叉树的后序遍历
//https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
//问题描述：给定一个 N 叉树，返回其节点值的后序遍历。


public class NAryTreePostorderTraversal {
    /**
     * 方法二：迭代 + 栈
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(node == null) continue;
            if(node.children != null){
                for (int i = node.children.size()-1; i >= 0 ; i--) {
                    stack.push(node.children.get(i));
                }
            }else {
                res.addFirst(node.val);
            }
        }
        return res;
    }


    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderifyDown(root, res);
        return res;
    }

    private void postorderifyDown(Node root, List<Integer> res) {
        if(root == null) return;
        if(root.children == null) return;
        for (Node child : root.children) {
            postorderifyDown(child, res);
        }
        res.add(root.val);
    }
}
