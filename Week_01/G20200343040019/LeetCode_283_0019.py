class Solution:

    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        i = 0
        j = 0
        size = 0
        length = len(nums)
        for i in range(length):
            if nums[i] == 0:
                size += 1
            else:
                nums[i-size], nums[i] = nums[i], nums[i-size]

        #1
        # noZero = filter(lambda x: x!=0, nums)
        # index = 0
        # for i in noZero:
        #     nums[index] = i
        #     index += 1

        # for i in range(index, len(nums)):
        #     nums[i] = 0
