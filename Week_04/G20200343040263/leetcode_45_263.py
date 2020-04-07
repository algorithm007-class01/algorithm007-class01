class Solution:
    def jump(self, nums: List[int]) -> int:
        step, max_bound, end = 0, 0, 0
        for i in range(len(nums) - 1):
            max_bound = max(max_bound, i + nums[i])
            if i == end:
                step += 1
                end = max_bound
        return step