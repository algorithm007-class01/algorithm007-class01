package com.studyWeek1;

/**
 * 爬楼梯
 */
public class ClimbStairs {
    /**
     * 思路：
     * 1级：1
     * 2级：2（11，2）
     * 3级：3 = 1级 + 2级
     * ......
     * n级：(n - 1)级 + (n -2)级
     * 该题为斐波那契数列题型
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int i = 1, j = 2;
        for (int k = 3; k <= n; k++) {
            int temp = i + j;
            i = j;
            j = temp;
        }
        return j;
    }

    /**
     * 直接利用数学公式，斐波那契数列公式
     * Fn = 1/根号5 (((1+根号5) / 2)^(n+1) - ((1-根号5) / 2)^(n+1))
     */
    public int climbStairsByFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibs = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibs / sqrt5);
    }
}
