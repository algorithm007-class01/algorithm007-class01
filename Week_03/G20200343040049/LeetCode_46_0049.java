class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> list, int[] nums, int level) {
        if (level == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(ans, list, nums, level + 1);
            list.remove(list.size() - 1);
        }
    }
}