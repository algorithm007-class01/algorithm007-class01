class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        from collections import deque
        if k == 0:
            return []
        d = deque()
        ans = []
        
        def clean_deque(i):
            if len(d) == 0:
                d.append(i)
            elif nums[i] < nums[d[-1]]:
                d.append(i)
            else:
                while len(d) != 0:
                    if nums[i] >= nums[d[-1]]:
                        d.pop()
                    else:
                        break
                d.append(i)
        
        ###
        for i in range(k):
            clean_deque(i)
        ans.append(nums[d[0]])
        
        for j in range(k,len(nums)):
            if d[0] == j-k:
                d.popleft()
            clean_deque(j)
            ans.append(nums[d[0]])
        return ans