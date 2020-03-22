from typing import List
#思考
#解法1：暴力法，两层循环嵌套一次挪动一个
#解法2：reverse大法，2次reverse之后即可
#解法3：使用额外数组后，再拷贝回原数组
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:         
        #利用List的内置方法,insert,pop，记录最后一个元素，删掉最后一个，在Index=0的位置插入，语法简洁，但是效率不敢恭维
        #PS:左转数组可以保存第一个元素，删掉第一个元素，然后append到最后
        length = len(nums)
        k = k % length
        for x in range(k):  
            temp = nums[length - 1]
            nums.pop(length - 1)
            nums.insert(0,temp)

class Solution2:
    def rotate(self, nums: List[int], k: int) -> None:                   
        #reverse大法，leetcode大神的做法
        #将数组后k位reverse,前length-k位reverse,然后整体reverse就得到答案了
        #里面有啥数学原理要好好思考下
        #python内置的reverse不如Java和c#的好用
        #复杂度O(n)
        length = len(nums)
        nums1 = nums[:length - k] 
        nums2 = nums[length - k:] 
        nums1.reverse()
        nums2.reverse()
        for x in nums2:
            nums1.append(x)
        nums1.reverse()
        for x in range(length):
            nums[x] = nums1[x]

class Solution3:
    def rotate(self, nums: List[int], k: int) -> None:      
        #较方法2更好理解，假设挪动3个位置，就倒数三个组成一个数组K1，前length-k个组成一个数组K2
        #将K1，K2所有数组append到新数组
        #python因为有切片所以语法稍微简洁
        #将新数组替换输入数组即可
        #时间复杂度O(n)
        #空间复杂度较高，开辟了3个数组
        new_nums = []
        length = len(nums) 
        for x in nums[-k:]:
            new_nums.append(x)
        for x in nums[:-k]:
            new_nums.append(x)
        for x in range(length):
            nums[x] = new_nums[x]

#######################函数调用##################################
nums = [1,2,3,4,5,6,7]
k = 3
sol = Solution3()
sol.rotate(nums,k)
print(nums)