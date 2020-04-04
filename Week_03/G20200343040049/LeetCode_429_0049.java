class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            // 如果这里不记录size的值，size会在循环中不断变化。
            // 记录size的值是因为，每一行节点的值要封装成list
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                temp.add(queue.peek().val);
                queue.addAll(queue.poll().children);
            }
            lists.add(temp);
        }
        return lists;
    }
}