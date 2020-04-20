//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


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
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        Map<Integer,List<Integer>> result = new HashMap<>();
        helper(root,1,result);
        return new ArrayList<>(result.values());
    }

    private void helper(Node node, int level, Map<Integer,List<Integer>> result){
        List<Integer> lr = result.get(level);
        if(lr == null) {
            lr = new ArrayList<>();
            result.put(level,lr);
        }
        lr.add(node.val);
        if (node.children != null && !node.children.isEmpty()){
            for (Node child : node.children) {
                helper(child,level+1,result);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
