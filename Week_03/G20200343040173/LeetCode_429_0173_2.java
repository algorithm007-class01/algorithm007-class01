import java.util.ArrayList;
import java.util.Arrays;
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

题目：429. N叉树的层序遍历

方法二：简化的广度优先搜索

个人理解：
    一层一层的遍历 values，通过交换层级来遍历完每一层的结点。

复杂度分析
    时间复杂度：O(n)O(n)。nn 指的是节点的数量。
    空间复杂度：O(n)O(n)，我们的列表包含所有节点。
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        List<Node> parentNodes = Arrays.asList(root);
        while (!parentNodes.isEmpty()) {
            List<Integer> parentVals = new ArrayList<Integer>();
            List<Node> childNodes = new ArrayList<Node>();

            for (Node node : parentNodes) {
                parentVals.add(node.val);
                childNodes.addAll(node.children);
            }

            result.add(parentVals);
            parentNodes = childNodes;
        }

        return result;
    }
}