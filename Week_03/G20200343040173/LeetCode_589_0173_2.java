import java.util.Collections;
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

题目：给定一个 N 叉树，返回其节点值的前序遍历。

第二种解法：迭代

前序遍历：根左右

官方解释注意点：
    我们使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点。
    我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点。
    随后每次我们从栈顶取出一个节点 u，它是我们当前遍历到的节点，并把 u 的所有子节点逆序推入栈中。
    例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v3, v2, v1，
    这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。

执行时间：2 ms

复杂度分析：
    时间复杂度：时间复杂度：O(M)，其中 M 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。
    空间复杂度：O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。
        将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1 个节点，因此栈的大小为 O(M)。

个人感受：
    前序遍历的时候，要先把根节点加入最后的输出 list 中。
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
            result.add(node.val);

            // 反转推入栈 右左，栈顶元素将会是 左右，符合真正的输出顺序
            Collections.reverse(node.children);

            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return result;
    }
}