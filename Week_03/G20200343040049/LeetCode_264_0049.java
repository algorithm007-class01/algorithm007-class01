class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; ++i) {
            ans[i] = Math.min(ans[p2] * 2, Math.min(ans[p3] * 3, ans[p5] * 5));
            if (ans[i] == ans[p2] * 2) ++p2;
            if (ans[i] == ans[p3] * 3) ++p3;
            if (ans[i] == ans[p5] * 5) ++p5;
        }
        return ans[n - 1];
    }
}