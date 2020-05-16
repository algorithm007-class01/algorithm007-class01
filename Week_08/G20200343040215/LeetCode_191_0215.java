public class LeetCode_191_0215 {
    public int hammingWeight(int n) {
        int count =0;
        while (n!=0){
            int p = n&(-n);
            n-=p;
            count++;
        }
        return count;
    }
}
