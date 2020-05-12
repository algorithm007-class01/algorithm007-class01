public class LeetCode_231_0147 {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 32; i++) {
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            if ((n & 1) == 0) {
                n = n >> 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(new LeetCode_231_0147().isPowerOfTwo(i));
    }
}
