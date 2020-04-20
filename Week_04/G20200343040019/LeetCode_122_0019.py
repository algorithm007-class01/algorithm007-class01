class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        res = 0
        pre = prices[0]
        for i in prices:
            if i > pre:
                res += i-pre
            pre = i
        return res