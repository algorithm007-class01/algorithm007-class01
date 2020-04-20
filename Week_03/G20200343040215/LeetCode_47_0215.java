package DailyPractice;

import java.util.*;

public class LeetCode_47_0215 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums,len,0,used,path,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<len;++i){
            if (used[i]){
                continue;
            }
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, used, path, res);
            used[i]=false;
            path.removeLast();

        }

    }


}
