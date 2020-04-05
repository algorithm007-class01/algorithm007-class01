package DailyPractice;

import Week_03.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_0215 {
    public List<Integer> preTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        preTraverse(resultList, root);
        return resultList;
    }

    private void preTraverse(List<Integer> resultList, TreeNode root) {
        if (root!=null) {
            resultList.add(root.val);
            if (root.left != null) {
                preTraverse(resultList, root.left);
            }

            if (root.right != null) {
                preTraverse(resultList, root.right);
            }
        }
    }
}
