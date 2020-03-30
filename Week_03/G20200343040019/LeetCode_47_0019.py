class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        listTemp = []
        res = []
        def backtrace(nums, tmp):
            if not nums:
                res.append(tmp)
                return
            for i in range(len(nums)):
                if tmp+[nums[i]] not in listTemp:
                    listTemp.append(tmp+[nums[i]])
                    backtrace(nums[:i]+nums[i+1:], tmp+[nums[i]])
        backtrace(nums, [])
        return res