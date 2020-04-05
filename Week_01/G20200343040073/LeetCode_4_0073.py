class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        index = m + n - 1
        while m > 0 and n > 0:
            if nums1[m-1] >= nums2[n-1]:
                a,m = nums1[m-1],m-1
            else:
                a,n = nums2[n-1],n-1
            nums1[index],index = a,index-1
        if n > 0:
            nums1[:n] = nums2[:n]
