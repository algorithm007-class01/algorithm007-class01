class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dic = {}
        cnums = [1] + nums + [1]
        
        @lru_cache(None)
        def click(i, j):
            if i+1==j:
                return 0
            return max(cnums[i]*cnums[k]*cnums[j]+click(i,k)+click(k,j) for k in range(i+1,j))
        return  click(0, len(nums)+1)
