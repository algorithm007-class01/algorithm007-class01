package DailyPractice;

import Week_03.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class LeetCode_94_0215 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        midTraverse(resultList, root);
        return resultList;
    }

    private void midTraverse(List<Integer> resultList, TreeNode root) {

        if (root != null) {
            if (root.left != null) {
                midTraverse(resultList, root.left);
            }
            resultList.add(root.val);
            if (root.right != null) {
                midTraverse(resultList, root.right);
            }
        }
    }
}
