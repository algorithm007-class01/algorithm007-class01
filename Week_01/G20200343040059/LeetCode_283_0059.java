/**
*   移动0
*   
*   使用一个指针标记0的下标,然后遍历，如果不为0讲值和指针交换，最后达到非0数据全部前移
*   时间复杂度O(n)
*
**/
class Solution {
    public void moveZeroes(int[] nums) {
        // 过滤空数组
        if (null == nums | nums.length == 0) {
            return;
        }

        // 标记0的位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 核心：把不等于0的所有数和index交换，最后非0都到最前面去了
            if (nums[i] != 0) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                index++;
            }
        }
    }
}