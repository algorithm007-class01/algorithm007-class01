class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        N = len(nums)

        l, r = max(nums), sum(nums)

        while l<r:
            mid = (l+r)//2
            cnt = 1
            curr = 0
            for i in range(N):
                # curr+=numsp
                if curr+nums[i] <= mid:
                    curr+=nums[i]
                else:
                    cnt+=1
                    curr = nums[i]

            if cnt > m:
                l = mid+1
            else:
                r = mid
        
        return l
        