class Solution:
    """ 两数之和 """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """ 一遍哈希表法
            参数：
                nums:给定的整形数组
                target:目标值
            返回值：
                和为目标值的两个整数，整数数组
            时间复杂度：
                O(n)
            空间复杂度：
                O(n)
        """
        h = {}
        for i, e in enumerate(nums):
            j = h.get(target - e)
            if j is not None and j != i:
                return [i,j] 
            h[e] = i
        return []

# class Solution:
#     """ 两数之和 """
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         """ 暴力法 
#             双重循环遍历从给定数组中找出和为目标值的两个整数并返回他们的下标
#             参数：
#                 nums:给定的整形数组
#                 target:目标值
#             返回值：
#                 和为目标值的两个整数，整数数组
#             时间复杂度：
#                 O(n^2)
#             空间复杂度：
#                 O(1)
#         """
#         length = len(nums)
#         for i in range(length-1):
#             for j in range(i+1, length):
#                 if nums[i] + nums[j] == target:
#                     return [i, j]
#         return []

# class Solution:
#     """ 两数之和 """
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         """ 两遍哈希表法
#             参数：
#                 nums:给定的整形数组
#                 target:目标值
#             返回值：
#                 和为目标值的两个整数，整数数组
#             时间复杂度：
#                 O(n)
#             空间复杂度：
#                 O(n)
#         """
#         h = {}
#         for i, e in enumerate(nums):
#             h[e] = i
#         for i, e in enumerate(nums):
#             j = h.get(target - e)
#             if j is not None and j != i:
#                 return [i,j]
#         return []

# class Solution:
#     """ 两数之和 """
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         """ python列表特性解
#             双重循环遍历从给定数组中找出和为目标值的两个整数并返回他们的下标
#             参数：
#                 nums:给定的整形数组
#                 target:目标值
#             返回值：
#                 和为目标值的两个整数，整数数组
#             时间复杂度：
#                 O(n^2)
#             空间复杂度：
#                 O(1)
#         """
#         for i in range(len(nums)):
#             temp = target - nums[i]
#             if temp in nums:
#                 j = nums.index(temp)
#                 if j != i:
#                     return [i,j]
#         return []