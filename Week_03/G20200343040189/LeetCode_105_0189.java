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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int plen = preorder.length;
        int ilen = inorder.length;
        if (preorder == null || plen == 0 || inorder == null || ilen == 0 || plen != ilen) {
            return null;
        }
        return helper(preorder, 0, plen - 1, inorder, 0, ilen - 1);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // 设置递归终止条件
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        // 本层处理的逻辑
        // 先序遍历的第一个元素就是根结点
        TreeNode treeNode = new TreeNode(preorder[pStart]);
        int index = 0;
        // 找到中序遍历的根结点和左子树结点个数
        // 右子树的结点个数为(整个数组长度-左子树结点个数-根结点)
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        // 递归下探到下一层
        // 构建左右子树
        // 左子树的根结点是先序遍历中的第二个元素，左子树结点是中序遍历中根结点之前的元素
        treeNode.left = helper(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        // 右子树的根结点是先序遍历中的第(index+1)个元素，右子树结点是中序遍历中根结点之后的元素
        treeNode.right = helper(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
