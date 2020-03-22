"""
189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
"""


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        # leetcode submit region end(Prohibit modification and deletion)
        size = len(nums)
        k %= size
        count = start = 0  # start是当出现循环时最开始的点
        while count < size:
            target = start
            tmp = nums[start]
            while True:
                target = (target + k) % size
                tmp, nums[target] = nums[target], tmp
                count += 1
                if count >= size or target == start:
                    break  # 次数到了或者出现循环则跳出
            start += 1
