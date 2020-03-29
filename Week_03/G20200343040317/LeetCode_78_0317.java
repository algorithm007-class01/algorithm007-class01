class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 这里一定要用CopyOnWriteArrayList，ArrayList 会有并发异常问题
        final List<List<Integer>> ans = new CopyOnWriteArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (List subSet : ans) {
                List<Integer> sub = new ArrayList<>(subSet);
                sub.add(nums[i]);
                ans.add(sub);
            }
        }
        return ans;
    }
}