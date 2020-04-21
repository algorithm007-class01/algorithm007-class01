/**
* Summary:best-time-to-buy-and-sell-stock-ii
* Parameters:
*   prices: price sequence
* Return: profit
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        int tmp  = 0;
        for (int i = 1; i < prices.size(); ++i) {
            tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
};