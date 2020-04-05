class Solution:
    def trap(self, height: List[int]) -> int:
        i = 0
        j = len(height)-1
        res = 0
        maxL = 0
        maxR = 0
        while i<j:
            l = height[i]
            r = height[j]
            maxL = max(maxL, l)
            maxR = max(maxR, r)
            if maxL <= maxR:
                res += min(maxL, maxR)-height[i]
                i+=1
            else:
                res += min(maxL, maxR)-height[j]
                j-=1
        return res
            