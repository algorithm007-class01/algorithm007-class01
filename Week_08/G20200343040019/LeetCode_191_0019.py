class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        # 2
        # while n!=0:
        #     res+= n & 1
        #     n = n>>1
        # return res
        while n!= 0:
            res += n%2
            n = n >>1
            # 3
            # n = n//2
            # 1
            # res+=1
            # n = n&(n-1)
        return res