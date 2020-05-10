class Solution:
    def reverseBits(self, n: int) -> int:
        ret, power = 0, 31
        while n:
            # 获得右边第一位的值，并将其左移31位
            ret += (n&1)<<power
            # 将n进行右移，相当于去掉最右边一位
            n = n >> 1
            # 反转操作，不断左移
            power -= 1