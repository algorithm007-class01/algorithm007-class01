//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> solution = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 0, k, 1);
        return result;
    }
    
    private void dfs(int n, int level, int k, int start) {
        if (level == k) {
            result.add(new ArrayList<>(solution));
            return;
        }
        
        for (int i = start; i <= n && n - start + 1 >= k - level; ++i) {
            solution.add(i);
            
            
            dfs(n, level + 1, k, i + 1);
            
            solution.remove(solution.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
