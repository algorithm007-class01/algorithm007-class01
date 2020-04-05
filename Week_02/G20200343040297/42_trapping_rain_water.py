class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        ans = 0
        s = []
        for i in range(len(height)):
            if s != []:
                while height[i] >= height[s[-1]]:
                    top = s.pop()
                    if s == []:
                        break
                    area = (min(height[i],height[s[-1]]) - height[top]) * (i - s[-1] - 1)
                    ans += area
            s.append(i)
            
        return ans