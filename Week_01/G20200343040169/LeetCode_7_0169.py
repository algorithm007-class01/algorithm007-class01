class Solution:
    """ 加一 """
    def plusOne(self, digits: List[int]) -> List[int]:
        """ 
            循环遍历加一
            参数：
                digits:给定的整形数组
            返回值：
                加一完成的整形数组
            时间复杂度:
                O(n)
            空间复杂度:
                O(1)
        """ 
        n = len(digits)
        for i in range(n - 1, -1, -1):
            digits[i] = (digits[i] + 1) % 10
            if digits[i] != 0:
                return digits
        digits.insert(0,1)
        return digits