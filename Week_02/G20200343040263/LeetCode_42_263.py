# 接雨水
# 暴力求解法 
# 遍历每个下标，寻找它左边和右边第一个比它最高的柱子，判断是否可以接到水，将可接水的结果累加即可
class solution:
    def trap(self, height: List[int]) -> int:
        ans = 0
        for i in range(len(height)):
            max_left, max_right = 0, 0
            for j in range(0, i):
                max_left = max(max_left, height[j])
            for j in range(i, len(height)):
                max_right = max(max_right, height[j])
            if min(max_left, max_right) > height[i]:
                ans += min(max_left, max_right) - height[i]
        return ans
# 双指针方法
# 双指针法就是将上边的一个下标 i，变为两个下标 left，right，
# 分别位于输入数组的两端。向中间移动时，边移动边计算。
class solution:
    def trap(self, height: List[int]) -> int:
        # 边界条件
        if not height: return 0
        n = len(height)
        left, right = 0, n-1
        maxleft, maxright = height[0], height[n-1]
        ans = 0
        while left <= right:
            maxleft = max(height[left], maxleft)
            maxright = max(height[right], maxright)
            if maxleft < maxright:
                ans += maxleft - height[left]
                left += 1
            else:
                ans += maxright - height[right]
                right -= 1
        return ans
#基于栈的方法进行实现 (此处的栈只是储存数组的下标)
# 栈顶元素a,当前元素b。
# 如果栈非空且，b>a,说明a处可接水。比较栈顶前一个元素与当前元素的大小，做差；计算二者的距离，面积即可得
# 而此处对于栈顶前一个元素的处理为：存储并弹出栈顶元素，前一个元素为栈顶元素，如此便可重复操作
# 距离=当前元素-栈顶前一个元素(栈顶元素已被弹出，因此栈顶前一个元素为栈顶元素)
# 高度：首先选择当前元素和栈顶前一个元素的小者(栈顶元素已被弹出，因此栈顶前一个元素为栈顶元素)，
    #   然后再与已弹出的栈顶元素做差，便可得到储水的高度
# 对面积进行累加
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:return 0
        ans = 0
        stack = []
        for current in range(len(height)):
            while stack and height[current] > height[stack[-1]]:
                top = stack.pop()
                if not stack: break
                distance = current - stack[-1] -1
                bound_height = min(height[current], height[stack[-1]]) - height[top]
                ans += ans + distance*bound_height
            stack.append(current)
        return ans