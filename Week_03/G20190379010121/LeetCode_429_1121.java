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
    //精髓在于size控制每层遍历的节点数
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0;i < size;i ++){
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}