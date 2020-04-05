package leetcode.editor.cn;//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), 0, nums, visited);
        return result;

    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int cur, int[] nums, int[] visited) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] != 1) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = 1;
            backtrack(ans, temp, cur + 1, nums, visited);
            temp.remove(temp.size() - 1);
            visited[i] = 0;
        }
    }

}


//leetcode submit region end(Prohibit modification and deletion)
