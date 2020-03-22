from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        #解法1：
        #这个题的思路使用3个指针，2个分别指向2个输入数组的最后一个有效数字p1,p2，第三个指针指向第一个数组尾部p3
        #比较p1,p2指向的值，哪个值大放入p3位置
        #当p1,p2都指向了数组0位置后退出循环
        p1,p2 = m - 1,n - 1
        p3 = m + n - 1
        while(p1 >= 0 and p2 >= 0):
            if(nums1[p1] > nums2[p2]):
                nums1[p3] = nums1[p1]
                p1-=1
            else:
                nums1[p3] = nums2[p2] 
                p2-=1
            p3-=1
        nums1[:p2+1]=nums2[:p2+1]

#######################函数调用##################################
sol = Solution()
nums1 = [0]
nums2 = [1]
m,n = 0,1
sol.merge(nums1,m,nums2,n)
print(nums1)
