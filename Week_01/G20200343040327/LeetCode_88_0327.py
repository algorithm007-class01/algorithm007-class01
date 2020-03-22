class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if m == 0 or n == 0:
            nums1[:] = nums2 or nums1
        else:
            up = m - 1
            down = n - 1
            end = m+n-1
            s = m-n
            while end > 0:
                if nums1[up] >= nums2[down]:
                    nums1[end] = nums1[up]
                    up -= 1
                else:
                    nums1[end] = nums2[down]
                    down -= 1
                end -= 1
                if up == -1:
                    nums1[:down-up] = nums2[:down-up]
                    end = 0
                if down == -1:
                    end = 0

