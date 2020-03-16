class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}

        for i in range(len(nums)):
            a = nums[i]
            if a in d:
                return [d[a], i]
            d[target-a] = i
        return []

        # 1 暴力
        # i = 0
        # j = 1
        # for i in range(len(nums)-1):
        #     for j in range(i+1, len(nums)):
        #         if nums[i]+ nums[j] == target:
        #             return [i, j]
