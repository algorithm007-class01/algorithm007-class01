public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        int i = 0;
        while(i < 32 ){
            if((n & mask) != 0){
                count ++;
            }
            mask <<= 1;
            i ++;
        }
        return count;
    }
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}