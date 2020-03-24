class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dct={}
        for i,n in enumerate(nums):
            if target-n in dct: return [dct[target-n],i]
            dct[n]=i
