class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        // 终止条件
        if(root == null){
            return;
        }
        // 从左往右遍历子树
        if(root.children != null){
            for (Node node : root.children ) {
                helper(node, res);
            }
        }
        //最后添加root节点
        res.add(root.val);
    }
}