import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (57.36%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    47.1K
 * Total Submissions: 81.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>(0);
        }

        // 使相同元素连续排放
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        dst(0, nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
    private void dst(int depth, int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            /**
             * 以[1,1,2]为例
             * 条件 <code>i > 0 && nums[i] == nums[i - 1]</code> 成立的情况有两种：
             * 1. used: [true,false,false]: 
             *     此时depth为1，即：将path[0]选择为nums[0]后，想要将path[1]选择为nums[1]，这种情况合理。
             * 2. used: [false,true,false]: 
             *     此时depth为0，即：想要将path[0]选择为nums[1]，如果允许这种情况，那么在该分支下，当depth进入1时，将会把path[1]选择为nums[0]。
             *     这样就会得到和第一种情况重复的结果。所以要判断<code>!used[i - 1]</code>。
             * 
             * 如果<code>i > 0 && nums[i] == nums[i - 1] && !used[i - 1]</code>成立，则说明:
             * 在处理完i - 1后，回溯了i - 1的状态（所以!used[i - 1]为真，且i - 1和i在同一depth上），
             * 然后进入i的处理逻辑，而i和i-1的值相同，所以可以将i剪枝。
             */
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dst(depth + 1, nums, used, path, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

