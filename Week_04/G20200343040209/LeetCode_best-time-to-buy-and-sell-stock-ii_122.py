class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        total = 0
        for index in range(len(prices)-1):
            addition = prices[index+1] - prices[index]
            if addition > 0:
                total += addition
        return total
