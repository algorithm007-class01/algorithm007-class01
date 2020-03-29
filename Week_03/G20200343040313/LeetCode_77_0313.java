package leetcode.editor.cn;//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution77 {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void helper(List<List<Integer>> ans, List<Integer> res, int i, int n, int k) {
        if (res.size() == k) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int first = i; first < n + 1; first++) {
            res.add(first);
            helper(ans, res, first + 1, n, k);
            res.remove(res.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
