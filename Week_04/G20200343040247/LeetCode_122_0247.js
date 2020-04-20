/**
 * @param {number[]} prices
 * @return {number}
 * 
 * 证明这个一思路可行
 */
var maxProfit = function(prices) {
    var maxprofit = 0;
      for (var i = 1; i < prices.length; i++) {
          if (prices[i] > prices[i - 1])
              maxprofit += prices[i] - prices[i - 1];
      }
      return maxprofit;
};