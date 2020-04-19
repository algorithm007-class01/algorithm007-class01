/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let res = 0;
    let len = prices.length;
    for (let i = 0; i < len - 1; i++) {
        res += Math.max(prices[i + 1] - prices[i], 0);
    }
    return res;
};