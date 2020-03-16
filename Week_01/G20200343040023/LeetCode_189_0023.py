# -*- coding: utf-8 -*-


class Solution(object):

    def rotate_1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        for i in range(k):
            nums.insert(0, nums.pop(-1))

    def rotate_2(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        _s = k % len(nums)
        nums[:] = nums[-_s:] + nums[:-_s]

    def rotate_3(self, nums, k):
        nums.reverse()
        a, b = nums[:k], nums[k:]
        a.reverse()
        b.reverse()
        nums[:] = a + b


if __name__ == "__main__":
    s = Solution()
    nums = [1, 2, 3, 4, 5, 6, 7]
    s.rotate_1(nums, 3)
    s.rotate_2(nums, 3)
    s.rotate_3(nums, 3)
