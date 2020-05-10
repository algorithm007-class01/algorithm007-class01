public class LeetCode_231_0145 {
    /**
     * 计算是否时 2 的幂次
     * */
    public boolean isPowerOfTwo(int n) {
        // 1.根据 条件 n >0 排除了 0000000001的情况
        // 2.n & (n-1) = 0 代表 二进制中 1 的个数 为 1 个
        // 00000000001000  & 00000000000111 = 0 符合条件
        return n > 0 && (n & (n - 1)) == 0;
    }
}
