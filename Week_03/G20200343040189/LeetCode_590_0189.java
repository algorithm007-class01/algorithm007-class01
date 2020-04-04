//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
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
};
*/

/**
 * 后序遍历 孩子根
 * 非递归解法
 */
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            // 使用LinkedList实现的offerFirst实现每次插入的孩子结点都在根结点之前
            list.offerFirst(cur.val);
            for (Node node: cur.children) {
                stack.push(node);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 递归解法
 */
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        for (Node node : root.children) {
            helper(node, list);
        }
        list.add(root.val);
    }
}