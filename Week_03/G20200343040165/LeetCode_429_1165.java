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
class Solution {
    //解法一：利用队列实现广度优先搜索
    // public List<List<Integer>> levelOrder(Node root) {      
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (root == null) return result;

    //     Queue<Node> queue = new LinkedList<>();
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         List<Integer> level = new ArrayList<>();
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             Node node = queue.poll();
    //             level.add(node.val);
    //             queue.addAll(node.children);
    //         }
    //         result.add(level);
    //     }
    //     return result;
    // }


    //解法二：递归
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }
    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
}