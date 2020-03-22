"""
# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
# 
# 示例:
# 
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
# 
# 说明:
# 
# 
# 必须在原数组上操作，不能拷贝额外的数组。
# 尽量减少操作次数。
"""

class Solution(object):
    def moveZeroes1(self, nums:list) -> None:
        firstZeroIndex = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[firstZeroIndex],nums[i] = nums[i],nums[firstZeroIndex]
                firstZeroIndex+=1
    
    def moveZeroes2(self, nums:list) -> None:
        not_zero = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[not_zero] = nums[i]
                not_zero += 1

        for i in range(not_zero, len(nums)):
            nums[i] = 0

    def moveZeroes3(self, nums:list) -> None:
        """
        滚雪球
        """
        snowball = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                snowball += 1
            elif snowball > 0:
                nums[i-snowball],nums[i] = nums[i],nums[i-snowball]
                

if __name__ == "__main__":
    solution = Solution()
    testList = [0,1,0,3,12]
    solution.moveZeroes1(testList)
    print("result1:",testList)

    # solution.moveZeroes2(testList)
    # print("result2:",testList)
