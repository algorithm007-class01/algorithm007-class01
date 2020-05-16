public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // ans 左移动一位,n取最后一位的值
            ans = (ans << 1) + (n & 1);
            // n 消掉最后一位
            n >>= 1;
        }
        return ans;
    }
}