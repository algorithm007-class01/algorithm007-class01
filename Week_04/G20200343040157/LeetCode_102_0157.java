//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
//        return dfs(root);
        return bfs(root);
    }

    // 方法一 DFS
    private List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1,result,root);
        return result;
    }

    /**
     * 收获：
     * 1. 如果想着用Map存储结果，可以看一下，是否key是数字，是否直接用ArrayList就可以了
     * 2. 还是老问题，递归是可以带着参数下去的，有时候带着level参数下去会很有用
     */
    private void helper(int level, List<List<Integer>> result, TreeNode node){
        if (node == null){
            return;
        }
        if (level > result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        helper(level+1,result,node.left);
        helper(level+1,result,node.right);
    }

    // 方法二 BFS
    /**
     * 收获：
     * 1. BFS的模板，用的是queue，queue不为空，则进行循环
     * 2. queue的元素不断在新增，如何取出现有的元素去做处理，不多取出
     *  2.1 先取出所有的元素，然后遍历所有的元素进行处理 （遍历两次）
     *  2.2 记住现在的长度n，遍历n次取出元素，同时进行处理（遍历一次）更高效
     */
    private List<List<Integer>> bfs(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if (node == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            // 这里的size一定要先拿出来，否则遍历过程中会变的
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                tmp.add(poll.val);
            }
            result.add(tmp);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
