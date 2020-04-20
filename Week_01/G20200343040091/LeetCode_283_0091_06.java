  class Solution {

    public void moveZeroes(int[] nums) {

      /**
       * 参考英文题解“1ms Java solution"
       *
       * 替换方式(这个方式就不单指那种挪动零了，可以换值。)
       *
       * 时间复杂度：O(n)
       * 空间复杂度：O(1)
       * */

      int temp = 0;
      for (int i = 0, j = 0; i < nums.length; i++) {
        if (0 != nums[i]) {
          temp = nums[j];
          nums[j] = nums[i];
          nums[i] = temp;
          j++;
        }
      }


    }// end of moveZeroes
  }