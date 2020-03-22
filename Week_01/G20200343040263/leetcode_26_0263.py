#删除重复元素
"""
class Solution():
    def removeDuplicates(self,num):
        i = 0
        while i < len(num)-1:
            if num[i] == num [i+1]:
                del num[i]
            else:
                i += 1
        return len(num)
"""
class Solution():
    def removeDuplicates(self,num):
        flag = 0
        if len(num)==0:
            return flag
        for i in range(1,len(num)):
            if num[i]!= num[flag]:
                flag += 1
                num[flag] = num[i]
        return flag+1