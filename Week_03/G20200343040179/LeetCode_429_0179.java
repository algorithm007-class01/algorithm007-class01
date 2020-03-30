package Week_03.G20200343040179;

import java.util.*;

/**
 * @author mufan
 * @date 2020/3/29
 */
public class LeetCode_429_0179 {
    /**
     * N叉树的层级遍历
     * 1.层级遍历自上向下,一层一层的遍历,当取出上一层的时候需要将下一层放入队里
     * 为什么这里用队列？队列的特点是先进先出,层级遍历总左到右放入队列,遍历处理刚好就是自己要的
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                li.add(poll.val);
                List<Node> childrens = poll.children;
                if (childrens != null && childrens.size() > 0) {
                    for (Node children : childrens) {
                        queue.add(children);
                    }
                }
            }
            list.add(li);
            queue.poll();
        }
        return list;
    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 1, res);
        return res;
    }

    private void dfs(Node root, int level, List<List<Integer>> res) {
        //terminator
        if (root == null) {
            return;
        }
        //process
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);
        //dill down
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), level + 1, res);
        }

    }
}
