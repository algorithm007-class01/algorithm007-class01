//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        boolean[] used = new boolean[size];
        divide(0, size, used, new ArrayList<Integer>(), nums);
        return result;
    }
    
    private void divide(int level, int n, boolean[] used, ArrayList<Integer> solution, int[] nums) {
        if (level == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
        
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                used[i] = true;
                solution.add(nums[i]);
                
                divide(level + 1, n, used, solution, nums);
                
                solution.remove(solution.size() - 1);
                used[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
