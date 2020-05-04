package ex.week7.homework;

public class LeetCode_70_0227 {
    //暴力递归
    public int climbStairs(int n) {
        //递归
        return method1(n);
        //递归 + 记忆化搜索
//        return method2(n);
        //dp
//        return method3(n);
//        return method4(n);
    }


    /**
     * 暴力递归解法
     *
     * @param n
     * @return
     */
    private int method1(int n) {
        if (n < 3) return n;
        return method1(n - 1) + method1(n - 2);
    }

    /**
     * 暴力递归解法 + 记忆化搜索
     *
     * @param n
     * @return
     */
    Integer[] memo;

    private int method2(int n) {
        memo = new Integer[n + 1];
        return memoHelper(n);
    }

    private int memoHelper(int n) {
        if (n < 3) return memo[n] = n;
        if (memo[n] != null) return memo[n];
        return memo[n] = memoHelper(n - 1) + memoHelper(n - 2);
    }

    public int method3(int n) {
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int method4(int n) {
        if (n < 3) return n;
        int f = 1;
        int s = 2;
        int t = 3;
        for (int i = 3; i <= n; i++) {
            t = f + s;
            f = s;
            s = t;
        }
        return s;
    }
}
