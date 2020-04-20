"""
Question:

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
"""

class Solution(object):
    def twoSumON2(self, nums:list, target: int) -> list:
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                if nums[i]+nums[j] == target:
                    return [i,j]
        
        return []

    def twoSumON(self, nums:list, target: int) -> list:
        hashDict = dict()
        for i in range(len(nums)):
            result_index = hashDict.get(target-nums[i], -1)
            if result_index != -1:
                return [result_index, i]
            else:
                hashDict[nums[i]] = i
        
        return []

if __name__ == "__main__":
    solution = Solution()    
    result = solution.twoSumON2([2, 7, 11, 15],9)
    print("O(n^2)时间复杂度：",result)
    result = solution.twoSumON([2, 7, 11, 15],9)
    print("O(n)时间复杂度：",result)