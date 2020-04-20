# -*- coding: utf-8 -*-


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        if not nums2:
            pass
        if not nums1:
            nums1[:] = nums2[:n]
        if nums1 and nums2:
            k = m + n - 1
            l_i, l_j = m - 1, n - 1
            while l_i >= 0 and l_j >= 0:
                if nums1[l_i] <= nums2[l_j]:
                    nums1[k] = nums2[l_j]
                    l_j -= 1
                else:
                    nums1[k] = nums1[l_i]
                    l_i -= 1
                k -= 1
            if (l_i >= 0):
                pass
            if (l_j >= 0):
                nums1[k - l_j:k + 1] = nums2[:l_j + 1]
