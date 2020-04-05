class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        i, j = 0, len(nums)-1
      
        while i<=j:
            m = (i+j)//2
            a,  b, c = nums[i], nums[m], nums[j]
            if a == target:
                return i
            elif b == target:
                return (i+j)//2
            elif c == target:
                return j
          
            if a<=b:
                if a<=target and b>=target:
                    j = m-1
                else:
                    i = m+1
            else:
                if  b <= target and c>=target:
                    i = m+1
                else:
                    j = m-1
        return -1
    