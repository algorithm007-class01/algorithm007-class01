class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        for nid,num in enumerate(nums):
            if hashMap.get(target-num) is not None:
                return [hashMap.get(target-num),nid]
            hashMap[num] = nid