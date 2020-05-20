#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode-cn.com/problems/4sum/
题目描述
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。

示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
"""

from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums: return []
        nums.sort()
        ans = set()
        self._find_sum(nums, 0, 4, target, [], ans)
        return list(ans)

    def _find_sum(self, nums, start, N, target, path, ans):
        if len(nums) < N or N < 2: return
        if N == 2:
            d = set()
            for k in range(start, len(nums)):
                if target - nums[k] in d:
                    ans.add(tuple(path + [target - nums[k], nums[k]]))
                else:
                    d.add(nums[k])
            # # 双指针法
            # l, r = start, len(nums) - 1
            # while l < r:
            #     if nums[l] + nums[r] == target:
            #         ans.add(tuple(path + [nums[l], nums[r]]))
            #         l, r = l+1, r-1     # 先移动指针
            #         while l < r and nums[l] == nums[l-1]: l += 1
            #         while l < r and nums[r] == nums[r+1]: r -= 1
            #     elif nums[l] + nums[r] < target:
            #         l += 1
            #     else:
            #         r -= 1
        else:
            for i in range(start, len(nums)):
                if target < nums[i] * N or target > nums[-1] * N: break
                if i == start or nums[i] != nums[i-1]:
                    self._find_sum(nums, i+1, N-1, target-nums[i], path+[nums[i]], ans)
        return
