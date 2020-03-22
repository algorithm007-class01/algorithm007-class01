"""
# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
# 
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
# 
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
# 
# 示例 1:
# 
# 输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
"""

class Solution:
    def plusOne1(self, digits: list) -> list:
        digits_str = ''.join([str(i) for i in digits])
        return [int(i) for i in str(int(digits_str)+1)]

    def plusOne2(self, digits: list) -> list:
        for i in range(len(digits)-1, -1, -1):
            digits[i] += 1
            digits[i] = digits[i] % 10
            if digits[i]:
                return digits
        digits.insert(0,1)
        return digits
            

if __name__ == "__main__":
    solution = Solution()
    result = solution.plusOne1([1,2,9])
    print("result:",result)
    result = solution.plusOne2([1,2,9])
    print("result2:",result)