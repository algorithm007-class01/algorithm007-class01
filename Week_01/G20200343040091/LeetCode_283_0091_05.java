  class Solution {

    public void moveZeroes(int[] nums) {

      /**
       * 参考中文题解“第一个题解：一次遍历，代码简洁，效率高100%,97.5%"
       *
       * 类似与冒泡的那种感觉，让非0的数字冒泡上来。
       * 其实是用zeroCount代替了那个慢指针。技术上来说感觉不够优秀。
       *
       * 时间复杂度：O(n)
       * 空间复杂度：O(1)
       * */

      int zeroCount = 0;

      for (int i = 0; i < nums.length; i++) {
        if (0 == nums[i]) {
          zeroCount++;
        } else if (zeroCount > 0) {// 这个判断也规避了[1]这种情况
          nums[i - zeroCount] = nums[i];// 把当前非0的数字往前挪动zeroCount位置
          nums[i] = 0;
        }
      }


    }// end of moveZeroes
  }
