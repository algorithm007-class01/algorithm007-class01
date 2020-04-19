public class LeetCode_122_0059 {


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }

    public static int maxProfit(int[] prices) {

        if (0 == prices.length) {
            return 0;
        }

        // 最后结果
        int res = 0;

        // 目前的值
        int before = prices[0];

        // 只要后面比现在大就直接交易
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > before) {
                res += prices[i] - before;
            }
            before = prices[i];
        }
        return res;
    }
}
