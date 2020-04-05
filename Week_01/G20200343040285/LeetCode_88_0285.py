class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        # 1 28ms    连接，排序 O（n+m)log(m+n)
        # nums1[:] = sorted(nums1[:m]+nums2)

        # 2 双指针，前-》后      时间 ：O（n+m),   空间： O(m)，num1 有效数先存
        # num1_cp = nums1[:m]
        # nums1[:] = []

        # p1 , p2 = 0, 0
        # while p1 < m and p2 < n:
        #     if num1_cp[p1] < nums2[p2]:
        #         nums1.append(num1_cp[p1])
        #         p1 +=1
        #     else:
        #         nums1.append(nums2[p2])
        #         p2 +=1
        # if p1 < m:
        #     nums1[p1+p2:] = num1_cp[p1:]
        # if p2 < n:
        #     nums1[p1+p2:] = nums2[p2:]

        # 3 双指针，后->前      时间 ：O（n+m),   空间： O(1)
      
        p1 = m - 1
        p2 = n - 1
        p = m + n - 1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1
        nums1[:p2+1] = nums2[:p2+1]
