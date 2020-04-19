class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        if len(nums)==1:
            return nums[0]

        i,j = 0, len(nums)-1

        while i<=j:
            m = (i+j)//2
            a,b,c = nums[i], nums[m], nums[j]

            if a <= c:
                return a
            
            if b>c:
                i = m+1
            else:
                if nums[m-1]<nums[m]:
                    j = m
                else:
                    return nums[m]
        return nums[i]