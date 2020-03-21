"""
88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
"""


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        i = 0
        j = 0
        nums_copy = nums1[:m]
        nums1[:] = []
        while i < m and j < n:
            if nums_copy[i] < nums2[j]:
                nums1.append(nums_copy[i])
                i = i + 1
            else:
                nums1.append(nums2[j])
                j = j + 1
        # if there are still element to add
        if i < m:
            nums1[i + j:] = nums_copy[i:]
        elif j < n:
            nums1[i + j:] = nums2[j:]


