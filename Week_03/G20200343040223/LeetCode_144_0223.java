package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_0223 {

    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    void helper(TreeNode root){
        if(root == null) return;
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }


}
