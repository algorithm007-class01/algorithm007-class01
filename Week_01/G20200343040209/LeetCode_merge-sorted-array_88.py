class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # method1
        middle_List = nums1[:m] + nums2[:n]
        middle_List.sort()
        nums1[:m+n] = middle_List

        # method2
        nums1[:m + n] = sorted(nums1[:m] + nums2[:n])

        # method3
        nums_middle = nums1.copy()
        if n == 0:
            nums1[:m] = nums1
        elif m == 0:
            nums1[:n] = nums2
        else:
            p1 = m - 1
            p2 = n - 1
            p = m + n - 1
            while (p1 >= 0 and p2 >= 0):
                # print(nums1[p1])
                # print(nums2[p2])
                if nums1[p1] >= nums2[p2]:
                    nums_middle[p] = nums1[p1]
                    # print(nums_middle)
                    p1 -= 1
                else:
                    nums_middle[p] = nums2[p2]
                    p2 -= 1
                p -= 1
            if p1 > 0:
                nums_middle[:p1 + 1] = nums1[:p1 + 1]
            elif p1 == 0:
                nums_middle[0] = nums1[0]
            elif p2 > 0:
                nums_middle[:p2 + 1] = nums2[:p2 + 1]
            elif p2 == 0:
                nums_middle[0] = nums2[0]
                print(nums_middle)
            nums1[:] = nums_middle
        # 这个跟官方的逻辑很相似，但是代码复杂度高了很多！需要后面再返回思考一下
        # 另外，这几种方法都比较消耗内存，完全搞不懂比我占用内存少的人是怎么写的！！！
