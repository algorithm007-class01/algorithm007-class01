class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def help(nums, tmp):
            if not nums:
                res.append(tmp)
                return
            for i in range(len(nums)):
                help(nums[:i] + nums[i+1:], tmp + [nums[i]])
        help(nums, [])
        return res