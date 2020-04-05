package DailyPractice;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46_0215 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int [] visited = new int[nums.length];
        backtrack(res,nums,new ArrayList<Integer>(),visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (visited[i]==1){
                continue;
            }

            visited[i]=1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i]=0;
            tmp.remove(tmp.size()-1);
        }

    }

}
