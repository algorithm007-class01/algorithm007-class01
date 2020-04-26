package com.lester.work;

import java.util.List;

public class leetcode_week06_0205 {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] A = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
                }
            }
            return A[0];
        }
    }

    class Solution2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[][] a = new int[n][2];

            a[0][0] = 0;
            a[0][1] = nums[0];

            for (int i = 1; i < n; i++) {
                a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
                a[i][1] = a[i - 1][0] + nums[i];
            }

            return Math.max(a[n - 1][0], a[n - 1][1]);

        }
    }

}
