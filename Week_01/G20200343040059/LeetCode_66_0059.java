/**
*   加一
*   个人最初的分析：
*       加一有2种情况，进位和不进位
*       进位有2种情况，进位的位置不需要再进位，进位的位置需要再进位
*       如果一直进位的话，数组长度的问题
*   时间复杂度O(n)
*
**/
class Solution {
    public int[] plusOne(int[] digits) {

        // 定义digits长度
        int len = digits.length;

        // 从尾部开始遍历
        for (int i = len - 1; i >= 0; i--) {
            // 将尾部的值加1
            digits[i]++;
            // 如果加了1后的值能被10整除，说明需要进位
            digits[i] = digits[i] % 10;
            // 如果不需要进位直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }

        // 如果没有在for循环里面return,说明属于99,999这种一直进位的数组，则数组长度+1
        digits = new int[len + 1];
        // 并在头部赋值1
        digits[0] = 1;
        return digits;
    }
}