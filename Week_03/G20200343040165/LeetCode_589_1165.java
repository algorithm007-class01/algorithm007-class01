class Solution {
    //解法一：迭代
    // public List<Integer> preorder(Node root) {
    //     LinkedList<Node> stack = new LinkedList<>();
    //     LinkedList<Integer> output = new LinkedList<>();
    //     if (root == null) {
    //         return output;
    //     }

    //     stack.add(root);
    //     while (!stack.isEmpty()) {
    //         Node node = stack.pollLast();
    //         output.add(node.val);
    //         Collections.reverse(node.children);
    //         for (Node item : node.children) {
    //             stack.add(item);
    //         }
    //     }
    //     return output;
    // }

    //解法二：递归
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }
    public void helper(Node root){
        if (root == null) return;
        res.add(root.val);
        for (int i = 0; i < root.children.size() ; i++) {
            helper(root.children.get(i));
        }
    }

}