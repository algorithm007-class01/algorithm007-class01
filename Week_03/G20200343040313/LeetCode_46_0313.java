package leetcode.editor.cn;//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        helper(result, new ArrayList<>(), 0, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> ans, List<Integer> list, int i, int[] nums, int[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited[j] == 1) {
                continue;
            }
            list.add(nums[j]);
            visited[j] = 1;
            helper(ans, list, i + 1, nums, visited);
            list.remove(list.size() - 1);
            visited[j] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
