# -*- coding: utf-8 -*-


class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        sum_num, current = 0, 0
        stack = []

        while current < len(height):
            while len(stack) != 0 and height[current] > height[stack[-1]]:
                h = height[stack[-1]]
                stack.pop(-1)
                if not stack: break
                distance = current - stack[-1] - 1
                t = min(height[stack[-1]], height[current])
                sum_num += distance * (t - h)

            stack.append(current)
            current += 1

        return sum_num


if __name__ == '__main__':
    s = Solution()
    print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))
