class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        pre_order(list,root);
        return list;
    }

    public void pre_order(List<Integer> list, TreeNode root){
        list.add(root.val);
        if (root.left != null){
            pre_order(list,root.left);
        }
        if (root.right != null){
            pre_order(list,root.right);
        }
        return;
    }
}