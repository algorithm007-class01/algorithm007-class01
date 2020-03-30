package week3.homework;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class LeetCode_105_0227 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //check param
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) return null;
        //重建根节点
        TreeNode treeNode = new TreeNode(preorder[pstart]);
        //index找到根节点在中序遍历的位置
        int index = 0;
        for (int i = istart; i < iend; i++) {
            if (inorder[i] == preorder[pstart]) break;
            else index++;
        }
//         前序遍历 preorder = [3,9,20,15,7]
//         中序遍历 inorder = [9,3,15,20,7]
        //重建左子树
        treeNode.left = helper(preorder, pstart + 1, pstart + index, inorder, istart, istart + index - 1);
        //重建右子树
        treeNode.right = helper(preorder, pstart + index + 1, pend, inorder, istart + index + 1, iend);
        return treeNode;


    }
}
