class Solution {
    //解法一：迭代
    // public List<Integer> postorder(Node root) {
    //     LinkedList<Node> stack = new LinkedList<>();
    //     LinkedList<Integer> output = new LinkedList<>();
    //     if (root == null) {
    //         return output;
    //     }

    //     stack.add(root);
    //     while (!stack.isEmpty()) {
    //         Node node = stack.pollLast();
    //         output.addFirst(node.val);
    //         for (Node item : node.children) {
    //             if (item != null) {
    //                 stack.add(item);
    //             }
    //         }
    //     }
    //     return output;
    // }

    //解法二：递归
    private List<Integer> res;
    public List<Integer> postorder(Node root) { 
        res = new LinkedList<>();
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            dfs(child);
        }
        res.add(root.val);
    }

}