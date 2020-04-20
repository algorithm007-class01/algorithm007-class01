class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        pre_order(list,root);
        return list;
    }

    public void pre_order(List<Integer> list, Node root){
        list.add(root.val);
        for (Node c: root.children){
            pre_order(list,c);
        }
        return;
    }
}