class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        tmp_dict = {}
        for index, value in enumerate(nums):
            if target-value in tmp_dict:
                return [tmp_dict[target-value], index]
            tmp_dict[value] = index