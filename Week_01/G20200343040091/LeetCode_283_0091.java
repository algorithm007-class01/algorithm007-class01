  class Solution {

    public void moveZeroes(int[] nums) {

      /**
       * 使用官方题解：最优解（双指针、快慢指针）
       * 相当简洁，学习！（不过java中没有C++那种swap操作，不给力,所以最优解只能写成覃超老师的那种方式。）
       *
       * 时间复杂度：O(n)操作是最优的。代码执行的总操作（数组写入）是非 0 元素的数量。这比上一个解决方案的复杂性（当大多数元素为 0 时）要好得多。但是，两种算法的最坏情况（当所有元素都为非 0 时）复杂性是相同的。
       * 空间复杂度：O(1) 只用了常量空间
       * */

      for (int i = 0, lastNonZeroFoundAt = 0; i < nums.length; i++) {
        if (0 != nums[i]) {
          nums[lastNonZeroFoundAt] = nums[i];
          if (i != lastNonZeroFoundAt) {// 要加判断，防止[1]变成[0]这种情况
            nums[i] = 0;// 直接将i位置置0即可（相当于做值交换）。
          }
          lastNonZeroFoundAt++;
        }
      }


    }// end of moveZeroes
  }
