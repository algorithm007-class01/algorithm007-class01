class Solution(object):
    """ 移动零 """
    def moveZeroes(self, nums):
        """ 遍历移动向前非零参数
            参数：
                nums:给定的整形数组
            返回值：
                无
            时间复杂度：
                O(n)
            空间复杂度：
                O(1)
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index] = nums[i]
                if index != i:
                    nums[i] = 0
                index = index + 1


# class Solution(object):
#     """ 移动零 """
#     def moveZeroes(self, nums):
#         """ 遍历交换数组元素，基于python多赋值特性
#             参数：
#                 nums:给定的整形数组
#             返回值：
#                 无
#             时间复杂度：
#                 O(n)
#             空间复杂度：
#                 O(1)
#         """
#         index = 0
#         for i in range(len(nums)):
#             if nums[i] != 0:
#                 nums[i], nums[index] = nums[index], nums[i]
#                 index = index + 1