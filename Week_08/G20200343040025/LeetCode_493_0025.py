#493.翻转对
class Solution(object):
    def reversePairs(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.inversions = 0
        self.Merge_Sort(nums, 0, len(nums)-1)
        return self.inversions
    def Merge_Sort(self, nums, l, r):
        if l >= r:
            return
        mid = l + (r - l) // 2
        self.Merge_Sort(nums, l, mid)
        self.Merge_Sort(nums, mid+1, r)
        i, j = l, mid+1
        while i <= mid and j <= r:
            if nums[j]*2 < nums[i]:
                # 当前左半部分，右半部分是排序好的
                # 左半部分的当前元素满足，则前元素的右边元素也满足
                # 故 mid + 1 - i
                self.inversions = self.inversions + mid + 1 - i
                j += 1
            else: 
                i += 1
        # 排序
        nums[l:r+1] = sorted(nums[l:r+1])
