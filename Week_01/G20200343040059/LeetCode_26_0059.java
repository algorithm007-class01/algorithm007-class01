/**
*   解题思路
*   使用双指针i,j，将index对应i,j的值进行判断,
*   如果不相等,则将index=i+1的值变为index=j的值
*   如果相等,j往后继续移动，直到出现不想等或者结束
*   时间复杂度o(n),空间复杂度O(1)
**/
class Solution {
    public int removeDuplicates(int[] nums) {

    // 数组非空判断
    if (null == nums || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}