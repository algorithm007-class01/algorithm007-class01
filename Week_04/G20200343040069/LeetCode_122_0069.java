class Solution {

    // 交易次数不限，每次都选择当下最优解---贪心
    //  时间复杂度 O(N) ： 只需遍历一次price；
    public int maxProfit(int[] prices) {
        int max = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}