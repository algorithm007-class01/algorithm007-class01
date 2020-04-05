class Solution {
    public double myPow(double x, long n) {
        // 技术处理
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        // 终结条件
        if (n == 0) {
            return 1.0;
        }
        // 子问题求解
        double result = 1.0;
        result = myPow(x, n / 2);
        result = result * result;
        // 优化三目表达式
        return n % 2 == 0 ? result : result * x;
        // if (n % 2 != 0) {
        //      result = result * x;
        //  }
        //  return result;
    }
}