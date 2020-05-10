package leetcode;

public class LeetCode_70_0223 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int res = 0, first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
