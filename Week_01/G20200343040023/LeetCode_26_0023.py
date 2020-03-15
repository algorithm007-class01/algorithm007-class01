# -*- coding: utf-8 -*-


class Solution(object):

    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        j, l = 0, len(nums)
        for i in range(l):
            if i+1 >= l:
                break
            if nums[i] != nums[i+1]:
                j += 1
                nums[j] = nums[i+1]

        return j + 1


if __name__ == "__main__":
    s = Solution()
    print(s.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]))
    # 5
