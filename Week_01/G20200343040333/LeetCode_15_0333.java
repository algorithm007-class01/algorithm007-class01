package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode_15_0333 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> numLists = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return numLists;
        }
        Arrays.sort(nums);// sort the arry
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int a = nums[i];
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    numLists.add(list);
                    while (left < right && b == nums[left + 1]) left++;
                    while (left < right && c == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }

            }
        }
        return numLists;
    }
}