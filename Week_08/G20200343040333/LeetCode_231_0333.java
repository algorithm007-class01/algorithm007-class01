public class LeetCode_231_0333 {
    //如果是2的幂次方 2^1,2^2 :0000 0010,0000 0100
    //二进制中只有一个1 所以n&(n-1)=0;
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&(n-1))==0;
    }
}