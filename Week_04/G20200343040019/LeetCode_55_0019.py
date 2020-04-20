class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums :
            return True
        left = len(nums)-1
        for i in range(len(nums)-1, -1, -1):
            if i+nums[i]>=left:
                left = i
        return left == 0