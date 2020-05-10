/**
 * 颠倒二进制位
 */
public class LeetCode190 {
    public int reverseBits(int n) {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            x = (x << 1) + (n & 1);
            n = n >> 1;
        }
        return x;
    }
}
