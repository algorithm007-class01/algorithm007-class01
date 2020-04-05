class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        for i in range(len(digits) - 1, -1, -1):
            if (digits[i]!=9):
                digits[i] += 1
                return digits
            digits[i] = 0
        digits.insert(0,1)
        return digits


input = [1, 2, 3]
ins = Solution()
res = ins.plusOne(input)