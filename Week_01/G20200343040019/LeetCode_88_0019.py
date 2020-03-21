class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        l = m+n-1
        n -= 1
        m -= 1
        while n>=0:
            if m<0 or nums1[m] < nums2[n]:
                nums1[l] = nums2[n]
                n -= 1
            else:
                nums1[l] = nums1[m]
                m -= 1
            l -= 1
        #1
        # for i in range(m, m+n):
        #     nums1[i] = nums2[i-m]
        # nums1[:] = nums1[:m] + nums2
        # nums1.sort()

        #2
        # for i in range(l, -1, -1):
        #     if n < 0:
        #         break
        #     elif m<0 or nums1[m] < nums2[n]:
        #         nums1[i] = nums2[n]
        #         n -= 1
        #     else:
        #         nums1[i] = nums1[m]
        #         m -= 1

            # if m<0 or nums1[m] < nums2[n]:

            # else:
            # l -= 1
        # nums1[:] = sorted(nums1[:m] + nums2)

        # j = 0
        # arr = nums1[:m + n]
        # for i in range(m, m + n):
        #     arr[i] = nums2[j]
        #     j += 1
        # arr.sort()
        # for i in range(m + n):
        #     nums1[i] = arr[i]
