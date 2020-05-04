package app;

public class LeetCode_70_0333 {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        
        
        int ans_2=1;
        int ans_1=ans_2+1;
        int t=3;
        while(t<=n){
            int temp=ans_1+ans_2;
            ans_2=ans_1;
            ans_1=temp;
            t++;
        }
        return ans_1;
        
    }
}