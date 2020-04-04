import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (73.18%)
 * Likes:    234
 * Dislikes: 0
 * Total Accepted:    41.6K
 * Total Submissions: 56.7K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dst(0, -1, k, n, new boolean[n], new ArrayList<>(), result);
        return result;
    }
    private void dst(int depth, int prevDepthIndex, int k, int n, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (depth == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = prevDepthIndex + 1; i < n; i++) {
            if (used[i]) {
                continue;
            }

            path.add(i + 1);
            used[i] = true;
            dst(depth + 1, i, k, n, used, path, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

