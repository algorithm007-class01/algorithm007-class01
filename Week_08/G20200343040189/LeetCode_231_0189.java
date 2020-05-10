//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// Related Topics 位运算 数学


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isPowerOfTwo(int n) {
        // n & (n - 1) 如果n是2的幂，则结果为0
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
