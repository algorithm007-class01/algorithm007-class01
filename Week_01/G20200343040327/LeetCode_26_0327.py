class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        count = 0
        length = len(nums)
        start = 0
        for i in range(1, length):
            if nums[i] == nums[start]:
                count += 1
            else:
                nums[start+1] = nums[i]
                start += 1
        return length-count