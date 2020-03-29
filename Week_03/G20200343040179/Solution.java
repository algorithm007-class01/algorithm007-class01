package Week_03.G20200343040179;

import java.util.HashMap;

/**
 * @author mufan
 * @date 2020/3/29
 */
class Solution {
    // start from first preorder element
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right){
            return null;
        }
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        pre_idx++;
        //构建左子树
        root.left = helper(in_left, index);
        //构建右子树
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }
}
