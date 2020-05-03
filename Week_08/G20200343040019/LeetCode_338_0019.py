class Solution:
    def countBits(self, num: int) -> List[int]:

        cache = {}
        def count(n):
            if n <=1:
                return n
            if n in cache:
                return cache[n]
            res = (n&1) + count(n>>1)
            cache[n] = res
            return res

        res =[]
        for i in range(num+1):
            res.append(count(i))
        return res