class Solution:
    """ 删除排序数组中的重复项 """
    def removeDuplicates(self, nums: List[int]) -> int:
        """ 快慢指针法
            参数：
                nums:给定的整型列表
            返回值：
                删除重复项后的数组长度
            时间复杂度：
                O(n)
            空间复杂度：
                O(1)
        """
        length = len(nums)
        if length == 0:
            return 0
        lastIndex = 0
        for i in range(length):
            if nums[lastIndex] != nums[i]:
                lastIndex = lastIndex + 1
                if lastIndex != i:
                    nums[lastIndex] = nums[i]
        return lastIndex + 1
        
# class Solution:
#     """ 删除排序数组中的重复项 """
#     def removeDuplicates(self, nums: List[int]) -> int:
#         """ 快慢指针法
#             参数：
#                 nums:给定的整型列表
#             返回值：
#                 删除重复项后的数组长度
#             时间复杂度：
#                 O(n)
#             空间复杂度：
#                 O(1)
#         """
#         length = len(nums)
#         i = 1 
#         count = 0
#         while i < length:
#             if nums[i] == nums[i-1]:
#                 count = count + 1
#             else:
#                 nums[i - count] = nums[i]
#             i = i + 1 
#         return length - count 