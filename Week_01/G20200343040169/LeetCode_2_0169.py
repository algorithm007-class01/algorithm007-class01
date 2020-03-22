class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """ 环形替换法
            参数：
                nums:给定的整型数组
                k:右移的个数
            时间复杂度:
                O(n)
            空间复杂度：
                O(1)
        """
        n = len(nums)
        k = k % n
        count = 0
        start = 0
        while count < n :
            prev = nums[start]
            current = start
            cond = True
            while cond:
                current = (current + k) % n
                temp = nums[current]
                nums[current] = prev
                prev = temp
                count = count + 1
                if current == start:
                    cond = False
            start = start + 1

# class Solution:
#     """ 旋转数组 """
#     def rotate(self, nums: List[int], k: int) -> None:
#         """ 暴力法
#             参数：
#                 nums:给定的整型数组
#             时间复杂度:
#                 O(n * k),最差时间复杂度时为o(n^2)
#             空间复杂度：
#                 O(1)
#         """
#         n = len(nums)
#         k = k % n 
#         for i in range(k):
#             temp = nums[n -1]
#             for j in range(n - 1, 0, -1):
#                 nums[j] = nums[j - 1]
#             nums[0] = temp

# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """ 反转法
#             参数：
#                 nums:给定的整型数组
#                 k:右移的个数
#             时间复杂度:
#                 O(n)
#             空间复杂度：
#                 O(1)
#         """
#         n = len(nums)
#         k = k % n 
#         self.reverse(nums, 0, n-1)
#         self.reverse(nums, 0, k-1)
#         self.reverse(nums, k, n-1)

#     def reverse(self, nums: List[int], start: int, end: int) -> None:
#         n = (end - start) // 2 + 1
#         for i in range(n):
#             nums[start + i],nums[end - i] = nums[end - i], nums[start + i]

# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """ 数组切片
#             参数：
#                 nums:给定的整型数组
#                 k:右移的个数
#             时间复杂度:
#                 O(n)
#             空间复杂度：
#                 O(n)
#         """
#         n = len(nums)
#         k = k % n 
#         nums[:] = nums[n-k:] + nums[:n-k]