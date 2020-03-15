class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 如果存在进位那么当前位上就会为0
            // 还会在执行一轮循环，前一位就会+1
            // 如果在循环退出前仍然没有返回，那么就是所有为都为9的情况了，这个时候需要新建一个数组，头位放上1即可
            if (digits[i] != 0) {
                return digits;
            }
        }
        final int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}