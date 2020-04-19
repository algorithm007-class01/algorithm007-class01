class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # 正向
        # a = 0
        # for i, n in enumerate(nums):
        #     if i > a:
        #         return False
        #     a = max(a, i + n)
        # return True

        # 反向
        goal = len(nums) - 1
        for i in range(goal, -1, -1) :
            if (nums[i] + i) >= goal:
                goal = i
        return goal==0

res = Solution().canJump([2,3,1,1,4])