class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;
        int preOfPre = 2, pre = 3, cur = 0;
        
        for (int i = 4; i <= n; ++i) {
            cur = pre + preOfPre;
            preOfPre = pre;
            pre = cur;
        }
        return cur;
    }
}