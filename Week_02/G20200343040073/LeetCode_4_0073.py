class Solution:
    def trap(self, height: List[int]) -> int:
        left,right=0,len(height)-1
        result=0
        leftMax,rightMax=0,0
        while left<right:
            leftMax=max(leftMax,height[left])
            rightMax=max(rightMax,height[right])
            if leftMax < rightMax:
                result+=leftMax-height[left]
                left+=1
            else:
                result+=rightMax-height[right]
                right-=1
        return result
