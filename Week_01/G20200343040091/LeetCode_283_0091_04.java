  class Solution {

    public void moveZeroes(int[] nums) {

      /**
       * 使用官方题解：空间最优，操作局部优化（双指针）（增加注释说明）
       * 1.把非0的数字紧挨着进行排列
       * 2.剩下的位置进行补0操作
       *
       * 其实是拆分的思路：满足所有非0元素按照顺序排列，然后所有0移动到末尾。
       *
       * 快指针往后遍历，慢指针记录非0。不会造成数据丢失，因为所有非0元素都做了记录。
       *
       * 时间复杂度：O(n) 代码执行的总操作（数组写入）为 n（元素总数）
       * 空间复杂度：O(1) 在数组上进行操作
       * */
      // 1.把所有非0的元素进行挪动
      int lastNonZeroFoundAt = 0;// 这个名字起得很好，表示的就是最后一个非0的位置，后面第2步直接用。
      for (int i = 0; i < nums.length; i++) {
        if (0 != nums[i]) {
          nums[lastNonZeroFoundAt++] = nums[i];// 这个++操作神来之笔，要学习。
        }
      }

      // 2.末尾全部补0
      for (int i = lastNonZeroFoundAt; i < nums.length; i++) { // 不需要用 nums.length - zeroCount 了
        nums[i] = 0;
      }

    }// end of moveZeroes
  }
