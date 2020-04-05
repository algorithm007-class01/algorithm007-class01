  class Solution {

    public int[] twoSum(int[] nums, int target) {

      /**
       * 暴力求解，双重循环遍历，判断是否相加等于target。如果相等，则进行输出
       *
       * 时间复杂度：O(n^2)，因为是双重遍历
       * 空间复杂度：O(1)，为什么不是O(n)的空间复杂度？不是用的数组吗？
       */

      for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {// 此处注意对j的初始值赋值控制
          if (target == nums[i] + nums[j]) {
            return new int[]{i, j};
          }
        }
      }

      return new int[0];

    }
  }
