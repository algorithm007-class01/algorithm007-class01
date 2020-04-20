import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (74.35%)
 * Likes:    576
 * Dislikes: 0
 * Total Accepted:    95K
 * Total Submissions: 127.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>(0);
        }

        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, used, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int depth, int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(depth + 1, nums, used, path, result);
            used[i] = false;
            path.remove(path.size() -  1);
        }
    }
}
// @lc code=end

