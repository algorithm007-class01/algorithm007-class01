# 两数之和
# 两数之和 哈希表(掌握)
class solution:
    def twoSum(self, num: List[int], target: int):
        hashmap = {}
        # 如果先把数组转化为字典，那么target - value的值可能为value,字典中的key是唯一的，
        # 所以后面再把数组里的数字作为key，下标作为value存到字典中
        for index, value in enumerate(nums):
            if target - value in hashmap:
                return hashmap[target - value], index
            else:
                hashmap[value] = index
# 双指针求解法 (掌握)
class solution:
    def twoSum(self, num: List[int], target: int):
        # 记录排序后的位置索引(不会真的对原nums排序)
        sortedlist = sorted(range(len(nums)), key = lambda x:num[x])
        left = 0
        right = n - 1
        while left < right:
            sum1 = nums[sortedlist[left]] + nums[sortedlist[right]]
            if sum1 == target:
                return [sortedlist[left], sortedlist[right]]
            elif sum1 < target:
                left += 1
            elif sum1 > target:
                right -= 1
# 暴力求解法
class solution:
    def twoSum(self, num: List[int], target: int):
        n = len(nums)
        for i in range(n):
            for j in range(i+1, n):
                if nums[i] + nums[j] = target:
                    return i, j
                else:
                    continue 