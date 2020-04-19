### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中

```python
# 查找最小元素所在的下标, 兼容含有重复元素
from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums: return

        i, j = 0, len(nums) - 1
        while i <= j:           # todo 二分查找条件一般是 i <= j
            mid = (i + j) // 2

            # todo 这个判断很重要, 是退出循环的条件
            if mid == j: break

            if nums[mid] > nums[j]:  # 左边有序
                i = mid + 1
            elif nums[mid] < nums[j]:  # 右边有序
                j = mid
            else:
                j -= 1
        return nums[j]
```
