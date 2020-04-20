//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null){
//            return result;
//        }
//        helper(root,result);
//        return result;
        return test(root);
    }

    private void helper(TreeNode node, List<Integer> result){
        result.add(node.val);
        if (node.left != null){
            helper(node.left, result);
        }
        if(node.right != null){
            helper(node.right, result);
        }
    }

    private List<Integer> test(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
