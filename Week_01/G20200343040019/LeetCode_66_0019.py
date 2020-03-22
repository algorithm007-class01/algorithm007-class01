class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # 4
        for i in range(len(digits)-1,-1,-1):
            digits[i] = (digits[i]+1)%10
            if digits[i] != 0:
                return digits

        digits.insert(0, 1)
        return digits

        # 2
        # if digits.count(9) == len(digits):
        #     return [1] + [0 for x in range(len(digits))]
        # 1
        # l = len(digits)-1
        # if digits[l]<9:
        #     digits[l] += 1
        #     return digits
        # else:
        #     while l>= 0:
        #         if digits[l] != 9:
        #             digits[l] += 1
        #             return digits
        #         digits[l] = 0
        #         l -= 1

        # digits.insert(0, 1)
        # return digits
        # 3

    #     return self.add(digits, len(digits)-1)


    # def add(self, digits: List[int], index:int) -> List[int]:
    #     if index < 0:
    #         digits.insert(0,1)
    #         return digits

    #     if digits[index] <9:
    #         digits[index] += 1
    #         return digits
    #     else:
    #         digits[index] = 0
    #         return self.add(digits, index-1)
