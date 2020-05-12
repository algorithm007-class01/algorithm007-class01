public class LeetCode_231_0215 {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        long x  = (long)n;//补码原因
        int count=0;
        while (x!=0 && count <=1){
            long p = x&(-x);
            x-=p;
            count++;
        }
        return count==1;
    }
}
