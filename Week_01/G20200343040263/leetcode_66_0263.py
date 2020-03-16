#加1操作
"""
class solution():
    def plusOne(self,digits):
        sums = 0
        for i in range(len(digits)):
            sums += 10**(len(digits)-1-i)*digits[i]
        sums_str = str(sums + 1)
        return [int(j) for j in sums_str]
"""
class solution():
    def plusOne(self,digits):
        n = len(digits)-1
        while True:
            if digits[n] == 9 and n == 0:
                digits[n] = 0
                digits.insert(0,1)
                break
            elif digits[n] == 9:
                digits[n] = 0
                n -= 1
            else:
                digits[n] += 1
                break
        return digits
