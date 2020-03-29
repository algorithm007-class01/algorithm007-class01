package week3.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class LeetCode_47_0227 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) return res;
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, List<Integer> cur, boolean[] visited) {
        if (nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            helper(res, nums, cur, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }

    }

    public List<List<Integer>> permuteUniqueex(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) return res;
        Arrays.sort(nums);
        helperex(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void helperex(List<List<Integer>> res, int[] nums, ArrayList<Integer> cur, boolean[] visited) {
        if (nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            helperex(res, nums, cur, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

}
