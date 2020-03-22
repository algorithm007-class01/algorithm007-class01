  class Solution {

    public void moveZeroes(int[] nums) {

      /**
       * 使用覃超老师视频的解法（增加注释说明）
       * */

      int j = 0;// 存储非0数字的位置

      for (int i = 0; i < nums.length; i++) {
        if (0 != nums[i]) {
          // 1.存储非0数字
          nums[j] = nums[i];

          // 2.这里其实就相当于换了个位置（当前i位置上的数字我已经替你保存放到j了。你现在的位置变成0就行了。）
          if (i != j) {
            nums[i] = 0;
          }

          // 3.每存储一个非0数字，则下标+1
          j++;
        }
        // continue; 如果是0，则不管，继续往后遍历就行了。
      }

    }
  }
