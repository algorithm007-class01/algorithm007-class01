public class LeetCode_191_0147 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(2));
    }
}
