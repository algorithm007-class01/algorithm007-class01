import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

方法一：利用队列实现广度优先搜索

个人理解：
    在原先后序排列（根左右）的基础上，保存每一层的结点数值。
    通过 queue 队列来控制每层结点的遍历。一层有几个结点就遍历几次。
    在遍历每层时把结点数值保存在当前 level 层的 list 中，最终加到 result 返回一个大的二维数组。

复杂度分析：
    时间复杂度：O(n)。n 指的是节点的数量。
    空间复杂度：O(n)。
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root ==null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();

            int size = queue.size();
            for (int i =0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            
            result.add(level);
        }

        return result;
    }
}