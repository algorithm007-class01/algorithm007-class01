//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
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
 * 先序遍历是  根孩子
 *
 * 非递归解法
 */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 构造一个栈，用来存放结点
        Stack<Node> stack = new Stack<>();
        // 先把根结点压栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 构造一个新结点用来接收栈中的结点
            // 因为是先序遍历，所以先将根结点弹出并加入到列表中
            Node cur = stack.pop();
            list.add(cur.val);
            // 将每个子结点都压入栈中
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 递归法实现前序遍历
 */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        list.add(root.val);
        for (Node node : root.children) {
            helper(node, list);
        }
    }
}