class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # digits[-1] += 1
        # for i in range(len(digits)-1, -1, -1):
        #     if digits[i] < 10:
        #         return digits
        #     digits[i] = 0
        #     if i == 0:
        #         return [1]+digits[:]
        #     digits[i-1] += 1
        return list(map(int, str(int(''.join(map(str, digits))) + 1)))