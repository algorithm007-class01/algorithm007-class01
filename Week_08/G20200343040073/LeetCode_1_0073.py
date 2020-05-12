# 191. 位1的个数
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        for i in range(32):
            count += (n >> i) & 1
        return count
