public class LeetCode_191_0333 {
    public int hammingWeight(int n) {
        int cnt=0;
        while(n!=0){
            n=n&(n-1);
            ++cnt;
        }
        return cnt;
    }
}