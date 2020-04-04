import java.util.List;
import java.util.ArrayList;

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

题目：429. N叉树的层序遍历

方法三：递归

个人理解：
    写一个递归函数，对每一层的每一个结点进行递归调用，保证同一层级的 val 都集合在同一个 levelVals 即可。

复杂度分析
    时间复杂度：O(n)。n 指的是节点的数量
    空间复杂度：正常情况 O(logn)，最坏情况 O(n)。运行时在堆栈上的空间。
*/
class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            traverseNode(root, 0);
        }
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
}