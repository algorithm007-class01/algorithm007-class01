class Solution:
    """ 合并两个有序数组 """
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """ 双指针/从后往前 
            参数：
                nums1:待插入整形数组
                nums2:插入的整形数组
                m:nums1存储数据数量
                n:nums2存储数据数量
            返回值：
            时间复杂度：
                O(m+n)
            空间复杂度：
                O(1)
        """
        pm = m - 1
        pn = n - 1
        while pm > -1 and pn > -1:
            if nums1[pm] >= nums2[pn]:
                nums1[pm + pn + 1] = nums1[pm]
                pm = pm - 1
            else:
                nums1[pm + pn +1] = nums2[pn]
                pn = pn - 1
        if pn > -1:
            nums1[:pn + 1] = nums2[:pn + 1]

# class Solution:
#     """ 合并两个有序数组 """
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         """ 合并后排序 
#             参数：
#                 nums1:待插入整形数组
#                 nums2:插入的整形数组
#                 m:nums1存储数据数量
#                 n:nums2存储数据数量
#             返回值：
#             时间复杂度：
#                 O((m+n)log(m+n))
#             空间复杂度：
#                 O(1)
#         """
#         nums1[:] = sorted(nums1[:m] + nums2)

# class Solution:
#     """ 合并两个有序数组 """
#     def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
#         """ 双指针/从前往后
#             参数：
#                 nums1:待插入整形数组
#                 nums2:插入的整形数组
#                 m:nums1存储数据数量
#                 n:nums2存储数据数量
#             返回值：
#             时间复杂度：
#                 O(m+n)
#             空间复杂度：
#                 O(m)
#         """
#         nums1Copy = nums1[:m]
#         pm = 0
#         pn = 0
#         nums1[:] = []
#         while pm < m and pn < n:
#             if nums1Copy[pm] <= nums2[pn]:
#                 nums1.append(nums1Copy[pm])
#                 pm = pm + 1
#             else:
#                 nums1.append(nums2[pn])
#                 pn = pn + 1
#         if pm < m:
#             nums1[pm + pn:] = nums1Copy[pm:]
#         if pn < n:
#             nums1[pm + pn:] = nums2[pn:]