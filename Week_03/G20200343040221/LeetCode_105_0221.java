/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.50%)
 * Likes:    385
 * Dislikes: 0
 * Total Accepted:    53.9K
 * Total Submissions: 83.5K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0 || null == inorder || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return findRoot(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode findRoot(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) {
            return null;
        }

        // 前序遍历：根->左->右，所以preorder当前范围的第一个位置就是当前根节点
        int rootValue = preorder[pstart];
        TreeNode root = new TreeNode(rootValue);

        // 找到当前根节点在inorder当前范围内的位置。
        // 在中序遍历中，根节点左边是左子树，右边是右子树。
        // 所以，在inorder中：
        //      从istart到istart + index - 1是当前根节点的左子树。(istart + index是当前根节点)
        //      从istart + index + 1到iend是当前根节点的右子树。
        // 在preorder中：
        //      从pstart + 1到pstart + index是当前根节点的左子树。
        //      从pstart + index + 1到pend是当前根节点的右子树。
        int index = 0;
        while (rootValue != inorder[istart + index]) {
            index++;
        }

        root.left = findRoot(preorder, pstart + 1, pstart + index, inorder, istart, istart + index - 1); 
        root.right = findRoot(preorder, pstart + index + 1, pend, inorder, istart + index + 1, iend);

        return root;
    }
}
// @lc code=end

