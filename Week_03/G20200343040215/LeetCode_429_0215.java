package DailyPractice;

import Week_03.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_0215 {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root==null){
            return resultList;
        }
           levelTraversal(root,resultList,0);
           return resultList;
    }

    private void levelTraversal(Node root, List<List<Integer>> resultList, int depth) {
        if (root==null){
            return ;
        }
        //判断是否为同一层，可以用递归树理解
        if (depth+1>resultList.size()){
            resultList.add(new ArrayList<>());
        }
        resultList.get(depth).add(root.val);
        for (Node node : root.children){
            if (node!=null) {
                levelTraversal(node, resultList, depth + 1);
            }
        }
    }


}
