public class LeetCode_231_0201 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        int count = 31;
        int res = 0;
        while (count-- > 0) {
            if ((n & 1) == 1) res++;
            n = n >> 1;
        }
        return res <= 1;
    }
}
