import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (65.01%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 25K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
class Solution {
    // 基于队列
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 一个层级下的节点数量
            int levelNodeCount = queue.size();
            List<Integer> levelValues = new ArrayList<>(levelNodeCount);

            while (levelNodeCount-- > 0) {
                Node node = queue.poll();
                levelValues.add(node.val);

                // 将下一层级的节点放入队列，排在当前层级的节点后面
                List<Node> children = node.children;
                if (null != children && children.size() > 0) {
                    for (int i = 0; i < children.size(); i++) {
                        queue.offer(children.get(i));
                    }
                }
            }

            result.add(levelValues);
        }

        return result;
    }

    // 基于递归的遍历
    public List<List<Integer>> levelOrder1(Node root) {
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        travel(root, 0, levelMap);
        return new ArrayList<>(levelMap.values());
    }
    private void travel(Node node, Integer deep, Map<Integer, List<Integer>> levelMap) {
        if (null == node) {
            return;
        }

        List<Integer> levelValues = levelMap.get(deep);
        if (null == levelValues) {
            levelValues = new ArrayList<>();
            levelMap.put(deep, levelValues);
        }
        levelValues.add(node.val);

        List<Node> children = node.children;
        if (null != children && children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                travel(children.get(i), deep + 1, levelMap);
            }
        }
    }
}
// @lc code=end

