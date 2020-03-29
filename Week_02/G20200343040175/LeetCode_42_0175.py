"""
接雨水


给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
"""

# 思路: 
# 求第i位置能装多少水，实际上就是求解min(max_left_i,max_right_i)-height[i]

class Solution:
    def trap(self, height: list) -> int:
        #暴力解法,时间复杂度O(n^2)，空间复杂度O(1)
        # trap_area = 0
        # for i in range(1, len(height)-1):
        #     max_left, max_right = 0,0
        #     #找左边的最大值
        #     for j in range(i+1):
        #         max_left = max(max_left, height[j])

        #     for j in range(i, len(height)):
        #         max_right = max(max_right, height[j])
            
        #     trap_area += min(max_left, max_right)-height[i]
        # return trap_area

        # #优化暴力解法，一般空间换时间优化,记忆法，记录左->右，右->左，对应位置上的最大值，时间复杂度O(n),空间复杂度O(n)
        # max_left_list = list()
        # max_right_list = list()

        # max_left, max_right = 0,0
        # #左->右，i位置左边的最大值
        # for i in range(len(height)):
        #     max_left = max(height[i],max_left)
        #     max_left_list.append(max_left)
        # #右->左，i位置右边最大值
        # for i in range(len(height)-1, -1, -1):
        #     max_right = max(height[i],max_right)
        #     max_right_list.append(max_right)
        # #右->左，i右侧最大值记录反了，需要翻转一下    
        # max_right_list.reverse()

        # trap_area = 0
        # for i in range(1,len(height)-1):
        #     trap_area += min(max_left_list[i],max_right_list[i]) - height[i]
        # return trap_area
    
        #双指针解法，在最高柱子两侧，我们分别从左到右，从右向左，计算雨水量min(max_left,max_right)-height(i)，
        # 只需关心左侧的最大值即可，右侧不需要关心是否是最大的，只需要比当前高即可
        if not height: return 0
        left, right = 0, len(height)-1
        max_left,max_right = height[left], height[right]
        trap_area = 0
        while left < right:
            max_left = max(max_left, height[left])
            max_right = max(max_right, height[right])

            if max_left < max_right:
                trap_area += max_left - height[left]
                left += 1
            else:
                trap_area += max_right-height[right]
                right -= 1
        return trap_area



if __name__ == "__main__":
    solution = Solution()
    print(solution.trap([0,1,0,2,1,0,1,3,2,1,2,1]))
