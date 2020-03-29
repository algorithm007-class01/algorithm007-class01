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

  
package com.dxm.leetcode.editor.cn;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return recursion(0, preorder.length-1, preorder, 0, inorder.length-1, inorder);
    }
    private TreeNode recursion(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int i = 0;
        for(;i<inorder.length;) {
            if (inorder[inStart + i] != preorder[preStart]) {
                i++;
            }
        }

        node.left = recursion(preStart+1, preStart+i, preorder, inStart, inStart+i-1, inorder);
        node.right = recursion(preStart, preEnd, preorder, inStart+i+1, inEnd, inorder);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}