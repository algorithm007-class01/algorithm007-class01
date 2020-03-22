/**
 * 66. 加一
 *
 * https://leetcode-cn.com/problems/plus-one/
 */
class Solution {
    public int[] plusOne(int[] digits) {
        // 主要考虑逢十进一的问题
        for (int i = digits.length - 1; i >= 0; i--) {
            // 加一
            digits[i]++;
            // 逢十进一
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        // 考虑999...问题
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}