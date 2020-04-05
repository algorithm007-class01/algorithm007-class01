package DailyPractice;

import Week_03.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_0215 {
    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        preTraversal(resultList, root);
        return resultList;
    }

    private void preTraversal(List<Integer> resultList, Node root) {
        if (root == null) {
            return;
        }
        resultList.add(root.val);
        if (root.children.size() >= 0) {
            for (Node child : root.children) {
                preTraversal(resultList, child);
            }
        }


    }
}
