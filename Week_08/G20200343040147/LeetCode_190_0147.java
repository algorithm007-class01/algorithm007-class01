public class LeetCode_190_0147 {

    public int reverseBits(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = (n >> i) & 1;
            num += (tmp << (31 - i));
        }
        return num;
    }
    
}
