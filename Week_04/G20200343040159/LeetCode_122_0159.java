/**
*122. 买卖股票的最佳时机 II <p>
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
*@author tim@timloong.win 
* 
*/
class Solution {
    public int maxProfit(int[] prices) {
        int allCount=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                allCount+=(prices[i]-prices[i-1]);
            }
        }

        return allCount;
    }
}