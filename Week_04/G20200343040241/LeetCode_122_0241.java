/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author wangcheng
 */
public class LeetCode_122_0241 {


    public int maxProfit(int[] prices) {
        int in=-1;
        int out=-1;
        int profit=0;
        for (int i = 1; i < prices.length; i++) {
            //涨了，而且未持股，就把昨儿的买入
            if(prices[i]>prices[i-1] && in==-1) in=prices[i-1];
            //跌了，持了股，就把昨儿的卖出
            else if(prices[i]<prices[i-1] && in!=-1) {
                out=prices[i-1];
                profit+=(out-in);
                in=-1;
            }
        }
        if(in!=-1) profit+=(prices[prices.length-1]-in);
        return profit;
    }


    public static void main(String[] args) {
        LeetCode_122_0241 leetCode = new LeetCode_122_0241();
        System.out.println(leetCode.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
