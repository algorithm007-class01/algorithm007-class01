package Week_03.G20200343040179;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/3/29
 */
public class LeetCode_105_0179 {
    private int preIndex = 0;
    private int[] preOrder;
    private int[] inOrder;
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 根据前序和中序构建二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        this.preOrder = preorder;
        this.inOrder = inorder;
        int index = 0;
        for (int inOrderVal : inorder) {
            map.put(inOrderVal, index++);
        }
        return dfs(0, inorder.length - 1);

    }

    /**
     * 核心的思想就是根据前序遍历的特点，第一个值肯定是根节点，然后根节点会将中序遍历进行一个切割
     * 然后前序的节点先后移动然后切割出来中序的两部分就会进行变化，不断地执行此过程
     * 相当于吧大的问题分解为了很多子问题
     */
    private TreeNode dfs(int start, int end) {
        //terminator
        if (start > end) {
            return null;
        }
        //process
        int rootVal = preOrder[preIndex];
        TreeNode treeNode = new TreeNode(rootVal);
        int inOrderIndex = map.get(rootVal);
        preIndex++;
        //dill down
        treeNode.left = dfs(start, inOrderIndex - 1);
        treeNode.right = dfs(inOrderIndex + 1, end);
        return treeNode;
    }
}
