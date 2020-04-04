class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        def perm(nums, tmp):
            if not nums:
                res.append(tmp)
            for i in range(len(nums)):
                if i < len(nums)-1 and nums[i] == nums[i+1]:
                    continue
                perm(nums[:i]+nums[i+1:], tmp+[nums[i]])
        perm(nums, [])
        return res

