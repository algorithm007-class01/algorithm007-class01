public class LeetCode_0190_0145 {
    /**
     * 二进制反转
     *  10001 => 从右往左 (1 * 2^4) + (0 * 2 ^3) + (0 * 2^2) + (0 * 2^1) + (0 * 2^0)
     * */
    public int reverseBits(int n) {
        int pow = 31;
        int res = 0;
        while (n != 0 & pow >= 0) {
            // 最后一位的值 乘以 幂次
            res += (n & 1) << pow;
            pow -= 1;
            n >>>= 1;
        }
        return res;
    }
}
