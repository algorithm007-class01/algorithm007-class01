# -*- coding: utf-8 -*-


class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        add_step = 0
        for i in range(len(digits)-1, -1, -1):
            if digits[i] + 1 <= 9:
                digits[i] = digits[i] + 1
                break
            else:
                digits[i] = 0
                add_step += 1
            if i == 0 and add_step:
                digits.insert(0, 1)

        return digits


if __name__ == '__main__':
    s = Solution()
    print(s.plusOne([8, 9, 9]))
