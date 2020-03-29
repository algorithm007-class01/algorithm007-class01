class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [nums]
        if len(nums) == 2:
            return [nums, nums[::-1]]
        num = nums[-1]
        nres = self.permute(nums[:-1])
        res = []
        for r in nres:
            for i in range(len(r)+1):
                res.append(r[:i]+[num]+r[i:])
        return res