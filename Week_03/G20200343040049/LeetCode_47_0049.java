class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<Integer>(), nums, used);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> list,
                           int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 剪枝掉1，1，2中，后面的1和前面的1顺序颠倒的情况，有这句话，就不用 判断ans里是否有list了。但前提要先把nums排一下序
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            if (used[i] == true)
                continue;
            list.add(nums[i]);
            used[i] = true;

            backtrack(ans, list, nums, used);
            // 回溯
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
