"""
class solution():
    def merge(self,nums1,m,nums2,n):
        nums1[:] = sorted(nums1[:m] + nums2)
        return nums1
"""
#时间复杂度为O(m+n)
#从结尾改写nums1的值，指针P用于追踪添加元素的位置
class solution():
    def merge(self,nums1,m,nums2,n):
        p1 = m - 1  #nums1保留的索引
        p2 = n - 1  #nums2保留的索引
        p = m + n - 1 #添加元素之和的总索引
        while p1 >= 0 and p2 >= 0: 
            if nums1[p1] <= nums2[p2]:#当nums2中添加的最后一个数大于nums1中的数时
                nums1[p] = nums2[p2] #添加至nums1的尾端，p2继续向前移动
                p2 -= 1
            else:                   #当nums2中添加的最后一个数小于nums1中的数时
                nums1[p] = nums1[p1] #将nums1中的元素添加至nums1的尾端
                p1 -= 1              #前面nums1的数与nums2的数继续进行比较
            p -= 1 #p向前移动
        nums1[p-p2:p2 + 1] = nums2[:p2 + 1] #添加丢失的元素 不懂最后一行代码
        return nums1