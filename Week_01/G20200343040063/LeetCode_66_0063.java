class Solution {

    // 三种情况
    //  1. 无进位
    //  2. 有进位
    //  3. 有进位，且多出一位
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i-- ){
            // 加1操作
            digits[i]++;
            // 取模，进位操作
            digits[i] %= 10;
            // 不等于0 ，进位完毕，直接返回
            if(digits[i] != 0){
                return digits;
            }
        }
        // 进位多出一位的情况
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}