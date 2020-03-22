#旋转数组
"""
对于[1,2,3,4,5,6,7][1,2,3,4,5,6,7]，
根据k=k%n，将数组分为两段：

第一段，对应数组下标范围[0,n-k-1][0,n−k−1]段，即[1,2,3,4]
第二段，对应数组下标范围[n-k,n-1][n−k,n−1]，即[5,6,7]
分为三步：

反转第一段，[4,3,2,1,5,6,7]
反转第二段，[4,3,2,1,7,6,5]
反转整体，[5,6,7,1,2,3,4]
完成！

"""
class Solution:
    def rotate(self,num,k):
        n = len(num)
        k = k % n
        def swap(l,r):
            while(l<r):
                num[l], num[r] = num[r], num[l]
                l += 1
                r -= 1
        swap(0,n-k-1)
        swap(n-k,n-1)
        swap(0,n-1)
        return num