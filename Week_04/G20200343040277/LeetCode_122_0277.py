"""
贪心算法：122
股票利润最大值
股价只要第二天比第一天高，就可以买卖，就算作利润
"""

class money():
    def maxPrice(self,price):
        price = [4,5,6,7,78]
        res = 0
        len = len(price)
        for i in len-1:
            diff = price[i+1]- price[i]
            if diff > 0:
                res += diff
                print(res)
            return res





