package week3.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 全排列，借助理解n皇后
 */
public class LeetCode_46_0227 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //回溯
        helper(nums, res, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> cur) {
        if (nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            helper(nums, res, visited, cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> permutEx(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helperex(nums, res, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void helperex(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> cur) {
        if (nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i]=true;
            cur.add(nums[i]);
            helperex(nums,res,visited,cur);
            visited[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}
