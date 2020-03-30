import heapq


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        uglynum = -1
        h = []  # 定义一个最小堆
        heapq.heappush(h, 1)  # 初始化堆为1
        while n > 0:
            while uglynum == h[0]:  # 去重复，如果发现堆顶与上一个丑数，一样，则丢弃
                heapq.heappop(h)
            uglynum = h[0]  # 去重后堆顶的数就是下一个丑数
            heapq.heappush(h, 2 * uglynum)
            heapq.heappush(h, 3 * uglynum)
            heapq.heappush(h, 5 * uglynum)
            n -= 1
        return uglynum
