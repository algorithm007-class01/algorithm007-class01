class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k == 0 or k > n:
            return []
        if n == k:
            return [[i for i in range(1,n+1)]]
        if  k == 1:
            return [[i] for i in range(1,n+1)]
        
        res = self.combine(n-1, k)
        for i in self.combine(n-1, k-1):
            i.append(n)
            res.append(i)
        return res