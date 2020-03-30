from typing import List
import collections
import heapq


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # python的堆默认为最小堆，当求topK的时候，最简单的办法就是push[-i]，-pop[0]的用法，推入取出都用相反数即可
        dic = collections.Counter(nums)
        h = []
        res = []
        for key, value in dic.items():
            # 堆元素可以为元组，元组第一个元素为比较值，用于需要跟踪主记录的情况（见官方文档）
            # [1, 1, 1, 2, 2, 3] 中，主记录为 1，2，3，排序值为 1，2，3对应的出现次数
            heapq.heappush(h, (-value, key))
        for value in heapq.nsmallest(k, h):
            res.append(value[1])
        return res

###########################函数调用#############################
nums = [1, 1, 1, 2, 2, 3]
k = 2
res = Solution().topKFrequent(nums, k)
print(res)
