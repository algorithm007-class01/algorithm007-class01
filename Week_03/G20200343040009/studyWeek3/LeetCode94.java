import com.studyWeek3.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> plusNumbers = new ArrayList<>();
            for (List<Integer> result : results) {
                List<Integer> newNumber = new ArrayList<>(result);
                newNumber.add(num);
                plusNumbers.add(newNumber);
            }
            results.addAll(plusNumbers);
        }
        return results;
    }


}