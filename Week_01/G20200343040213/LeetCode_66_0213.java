class Solution {
    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return new int[]{};
        }

        int last = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int t = digits[i] + last;
            digits[i] = t % 10;
            if ((last = t / 10) == 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}