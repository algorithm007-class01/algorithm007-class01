class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        remove_num = k % len(nums)
        nums[:] = nums[-remove_num:] + nums[:-remove_num]
