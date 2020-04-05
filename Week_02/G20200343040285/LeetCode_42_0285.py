#
# @lc app=leetcode.cn id=42 lang=python
#
# [42] 接雨水
#
# https://leetcode-cn.com/problems/trapping-rain-water/description/
#
# algorithms
# Hard (49.37%)
# Likes:    945
# Dislikes: 0
# Total Accepted:    64.4K
# Total Submissions: 130.1K
# Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
#
# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
# 
# 
# 
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
# Marcos 贡献此图。
# 
# 示例:
# 
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
# 输出: 6
# 
#
from collections import Counter, OrderedDict,deque
# @lc code=start
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # 两边不可能
        # 第一个>0右边的开始。
        # 找中间低，两边高的
     
        
        if not height: return 0
        left = 0
        right = len(height) - 1
        res = 0
        # 记录左右边最大
        left_max = height[left]
        right_max = height[right]
        while left < right:
            if height[left] < height[right]:
                if left_max > height[left]:
                    res += left_max - height[left]
                else:
                    left_max = height[left]
                left += 1
            else:
                if right_max > height[right]:
                    res += right_max - height[right]
                else:
                    right_max = height[right]
                right -= 1 
        return res

res = Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1])
# @lc code=end

