/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 */
public class ClimbingStairs {

    public static void main(String[] args){
        System.out.println(new ClimbingStairs().d_climbStairs(1));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb(n,n, memo);
    }

    /**
     * 记忆化 递归，不重复
     * @param level
     * @param n
     * @param memo
     * @return
     */
    public int climb(int level, int n,int[] memo) {
        if(level == 1)return 1;
        if(level == 2) return 2;
        return memo[level] > 0?
                memo[level]:(memo[level] = climb(level-1,n,memo) + climb(level-2,n,memo));
    }

    /**
     * 动态规划
     */
    public int d_climbStairs(int n){
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
