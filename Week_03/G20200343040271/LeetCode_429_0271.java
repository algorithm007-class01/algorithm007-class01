/*
429. N叉树的层序遍历
https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
问题描述：给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
*/
public class NAryTreeLevelOrderTraversal {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 方法一：递归
     * 核心：确保节点当前层的列表顺序就可以了
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        if (root != null) levelOrderifyDown(root, 0);
        return res;
    }

    private void levelOrderifyDown(Node root, int level) {
        if(root == null) return;
        if (res.size() <= level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node child:root.children) {
            levelOrderifyDown(child, level+1);
        }
    }
}
