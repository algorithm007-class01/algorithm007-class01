class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        helper(nums, visited, res, new ArrayList());
        return res;
    }

    private void helper(int[] nums, int[] visited, List<List<Integer>> res, List<Integer> tmp){
        if(tmp.size()  == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0; i< nums.length;i++){
            if(visited[i] == 1 ||
                    (i > 0 && visited[i - 1] == 0 && nums[i -1] == nums[i]) ) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            helper(nums, visited, res, tmp);
            tmp.remove(tmp.size()-1);
            visited[i] =  0;
        }
    }
}