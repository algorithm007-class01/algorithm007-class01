//颠倒给定的 32 位无符号整数的二进制位。
//
//
// Related Topics 位运算


//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        // 32位无符号整数
        for (int i = 0; i < 32; i++) {
            // res右移一位
            res <<= 1;
            // n&1可以求得n的最后一位是0还是1
            // res与之按位或可以将n尾部的元素转移到res头部
            res |= (n & 1);
            // n不断左移
            n >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
