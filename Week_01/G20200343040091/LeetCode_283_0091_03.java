  class Solution {

    public void moveZeroes(int[] nums) {

      /**
       * 使用官方题解空间局部优化解法（增加注释说明）
       * 1.计算0的个数
       * 2.把非0的数字紧挨着进行排列
       * 3.剩下的位置进行补0操作
       *
       * 时间复杂度：O(n) 虽然循环了3次，是O(3n),但是不关心系数
       * 空间复杂度：O(n) 在数组上进行操作
       * */
      int zeroCount = 0;// 用来记录当前数组0的个数

      // 1.计算0的个数
      for (int i = 0; i < nums.length; i++) {
        if (0 == nums[i]) {
          zeroCount++;
        }
      }

      // 2.把所有非0的元素进行挪动
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (0 != nums[i]) {
          nums[j] = nums[i];
          j++;
        }
      }

      // 3.末尾全部补0
      for (int i = nums.length - zeroCount; i < nums.length; i++) {
        nums[i] = 0;
      }


    }// end of moveZeroes
  }
