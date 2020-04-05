class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        index = 1
        for i in range(len(nums)):
            if i == 0:
                pre = nums[i]
                continue
            if nums[i] != pre:
                pre = nums[i]
                nums[index],nums[i] = nums[i],nums[index]
                index += 1
        return index
