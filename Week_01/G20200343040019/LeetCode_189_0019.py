class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k%=n
        nums[:]=nums[::-1]
        nums[:k]=nums[:k][::-1]
        nums[k:]=nums[k:][::-1]

        # 1 --120 ms	14 MB
        # for i in range(k):
        #     item = nums.pop()
        #     nums.insert(0, item)


        #   2   out time
        # for i in range(k):
        #     item = nums[len(nums)-1]
        #     for j in range(len(nums)):
        #         item, nums[j] = nums[j], item

        # 3
        # nums[:] = nums[l-k:]+ nums[:l-k]
