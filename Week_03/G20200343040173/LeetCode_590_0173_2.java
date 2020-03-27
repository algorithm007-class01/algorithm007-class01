import java.util.LinkedList;
import java.util.List;

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

题目：给定一个 N 叉树，返回其节点值的后序遍历。

第二种解法：迭代

后序遍历：左右根

官方解释注意点：
    使用一个栈来得到后序遍历。我们首先把根节点入栈。
    当每次我们从栈顶取出一个节点 u 时，就把 u 的所有子节点顺序推入栈中。
    例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v1, v2, v3，
    这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v3）出现在栈顶的位置。
    在遍历结束之后，我们把遍历结果反转，就可以得到后序遍历。

执行时间：2 ms

复杂度分析：
    时间复杂度：时间复杂度：O(M)，其中 M 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。
    空间复杂度：O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。
        将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1 个节点，因此栈的大小为 O(M)。

个人感受：
    后续遍历的时候，要先把根节点加入第一个输出 list 中。
    迭代的时候，把下一个要迭代的 Node 推入栈内
*/
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<Integer>();

        if (root == null) {
            return result;
        }

        LinkedList<Node> stack = new LinkedList<Node>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);

            for (Node item : node.children) {
                stack.add(item);
            }
        }

        return result;
    }
}