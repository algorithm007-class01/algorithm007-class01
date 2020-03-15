from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 0:  #review的时候发现了数组为空的bug，修改
            return length
        else:
            y = 0
             #方法1双指针解法，较优解，使用java可以1ms运算时间，PS:不知道是不是leetcode对java有单独优化O_O
             #1定义x,y，y为数组index，x为需要检查的数index
             #2当x,y分别对应的值不同时，则将nums[y]值交换到角标为x+1的位置，然后x++
             #3最后返回y+1

            for x in range(1,length):
                if nums[y] != nums[x]:
                    nums[y + 1] = nums[x]
                    y = y + 1
            return y + 1
            
class Solution2:
    def removeDuplicates(self,nums: List[int]) -> int:    
        #方法二：利用python的语法糖，可以使用List长度可变的语法特点（其实和c#与java
        #LIST也是有类似功能），只是这种接法不是原地算法，但是更加简洁
        #其实这种方法已经偏题了，放在这里作为思维的拓展
        #1.定义变量temp记录Nums上一个检查的值，初值为nums[0]，发现与temp不相等的值直接append到新list,然后刷新temp变量即可，最后返回新数组与长度即可
        #2.再将数组拷贝回原数组即可
        length = len(nums)
        if length == 0:
            return 0
        temp = nums[0]
        new_nums = [nums[0]]
        for x in nums[1:]:
            if temp != x:
                new_nums.append(x)
                temp = x
        for x in range(0,len(new_nums)):
            nums[x] = new_nums[x]
        return len(new_nums)


########################以下为函数调用部分##################################
nums = [0,0,2,3,4,4,4,5,6,7,7]
sol = Solution2() 
res = sol.removeDuplicates(nums) 
print(res)
print(nums)