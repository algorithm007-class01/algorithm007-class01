class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        add = 1
        for i in range(len(digits)-1,-1,-1):
            sum = digits[i] + add
            digits[i] = sum % 10
            add = sum // 10
            if add == 0: break
        if add is not 0: digits = [add] + digits
        return digits
