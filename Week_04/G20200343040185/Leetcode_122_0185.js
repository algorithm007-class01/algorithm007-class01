var maxProfit = function(prices) {
  let sum = 0;
  for (let i = 0; i < prices.length -1; i++) {
    if (prices[i + 1] > prices[i]) {
      sum += prices[i + 1] - prices[i];
    }
  }
  return sum;
};