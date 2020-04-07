class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums)<=1:
            return True
        ans = [False for i in range(len(nums))]
        ans[0] = True
        for i in range(0,len(nums)):
            if ans[i]==True:
                ans[(i+1):(i+(nums[i])+1)] = [True]*nums[i]
            else:
                break
        #print(ans)
        return ans[len(nums)-1]
 