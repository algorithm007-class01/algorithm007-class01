class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        # def merge(a, b):
        #     a1,a2 = a[0],a[1]
        #     b1,b2 = b[0],b[1]
        #     if a2>=b1:
        #         return [[min(a1,b1), max(a2,b2)]]
        #     return [a, b]

        intervals.sort()
        res = []
        
        for i in intervals:
            if not res or res[-1][1]<i[0]:
                res.append(i)
            elif res[-1][1]<i[1]:
                res[-1][1]=i[1]
        return res