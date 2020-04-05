package Week_03.G20200343040179;

import java.util.*;

/**
 * @author mufan
 * @date 2020/3/29
 */
public class LeetCode_46_0179 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length <= 0) {
            return res;
        }
        generate(nums, new ArrayList<>());
        return res;
    }

    private void generate(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            generate(nums, list);
            list.remove(list.size() - 1);
        }
    }
}
