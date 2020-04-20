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

    private List<List<Integer>> result = new ArrayList<>();
    // 1.递归 时间复杂度O(n) 空间复杂度O(logn) 最坏O(n)
    public List<List<Integer>> levelOrder_01(Node root) {
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

    // 2.广度优先搜索 使用队列记录已经遍历过的节点 时间复杂度O(n) 空间复杂度O(n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == root) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}