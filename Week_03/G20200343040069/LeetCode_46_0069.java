class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtracking(nums,0, res, new Stack<>(), visited);
        return res;
    }

    private void backtracking(int[] nums, int begin, List<List<Integer>> res, Stack<Integer> tmp, int[] visited){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i< nums.length;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            tmp.push(nums[i]);
            backtracking(nums,i+1, res, tmp, visited);
            tmp.pop();
            visited[i] = 0;
        }
    }
}