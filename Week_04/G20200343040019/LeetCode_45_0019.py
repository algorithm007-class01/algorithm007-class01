class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums)==1:
            return 0
        stack = [sys.maxsize for _ in range(len(nums))]
        stack[-1] = 0
        left = len(nums)-1
        for i in range(len(nums)-2, -1, -1):
            step = nums[i]
            if i+step>=left:
                index = min(stack[i:i+step+1])
                stack[i] =index+1
            left = i
        return stack[0]