//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int index = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0 ; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int left, int right) {
        if (left == right) {
            index++;
            return new TreeNode(inorder[left]);
        } else if (left > right)
            return null;
        
        TreeNode curr = new TreeNode(preorder[index++]);
        
        int mid = map.get(curr.val);
        curr.left = helper(left, mid - 1);
        curr.right = helper(mid + 1, right);
        
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
