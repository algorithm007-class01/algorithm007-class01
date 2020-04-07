package com.studyWeek1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * a + b + c = 0; 等价两数之和
 * a + b = -c（多种情况）; ------> a + b = target;
 *
 * 首尾指针
 * 1. 排序
 * 2. 数组第一个数大于0，即不存在
 * 3. sum > 0 左指针+1
 * 4. sum < 0 右指针-1
 * 5. sum = 0 左指针+1，右指针-1并做重复项判断
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int left = k + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    // 大于0 有指针向左移
                    left++;
                } else if (sum > 0) {
                    // 小于0 有指针向右移
                    right--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[left], nums[right])));
                    // 避免重复结果
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }

        return result;
    }
}
