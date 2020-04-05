package DailyPractice;

import Week_03.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_0215 {
    public List<Integer> postorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        afterPreTraversal(resultList,root);
        return resultList;
    }

    private void afterPreTraversal(List<Integer> resultList, Node root) {
        if (root!=null){
            if (root.children.size()>=0) {
                for (Node child : root.children) {
                    afterPreTraversal(resultList, child);
                }
            }
            resultList.add(root.val);
        }
    }
}
