#两数之和 
"""
  先创建一个空字典，
  #然后依次把target-nums[x]的值存入字典，存入一个就跟nums[x+1]去比较， 
  #字典中的key为target-nums[x],value为x，也就是nums[x]在nums列表中的索引位置。
  #当字典d中有nums[x+1]时，也就是target - nums[y] = nums[x+1] , y肯定是小于x+1的(因为y是x+1之前循环过的数字)
 """
class Solution:
    def twoSum(self,num,target):
        if len(num)<0:
            return False
        dict1 = {}
        for i in range(len(num)):
            if num[i] in dict1:
                return [dict1[num[i]],i]
            else:
                dict1[target - num[i]] = i