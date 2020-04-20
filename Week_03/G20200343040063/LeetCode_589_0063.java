class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        //终止条件
        if(root == null) return;
        //添加父节点
        res.add(root.val);
        // 遍历子树
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i), res);
        }
    }
}