//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> solution = new ArrayList<>();
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        used = new boolean[size];
        dfs(nums, size, 0);
        return result;
    }
    
    private void dfs(int[] nums, int size, int level) {
        if (level == size) {
            result.add(new ArrayList<>(solution));
            return;
        }
        
        for (int i = 0; i < size; ++i) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            solution.add(nums[i]);
            
            dfs(nums, size, level + 1);
            
            solution.remove(solution.size() - 1);
            used[i] = false;
            
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
