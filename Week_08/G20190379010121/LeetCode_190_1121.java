public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int power = 31;
        while(power != 0){
            res += (n & 1) << power;
            n = n >>> 1;
            power --;

        }
        return res;
    }
     public int reverseBits(int n) {
         int ans = 0;
         for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
             ans += (n & 1) << bitsSize;
         }
         return ans;
     }
}