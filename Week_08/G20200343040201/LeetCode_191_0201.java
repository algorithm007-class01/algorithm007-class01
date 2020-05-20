public class LeetCode_191_0201 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int count = 32;
        while(count-- > 0) {
            if ((n & 1) == 1) res++;
            n = n >> 1;
        }
        return res;
    }
}
