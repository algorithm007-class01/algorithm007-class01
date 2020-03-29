import collections
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #算法：创建一个dict将每个单词按字母排序后当做dict的键，原单词直接append到键对应的list中即可
        #貌似用deafultDict可以更省事，deaflultDict(list)可以限定value为list，dict不能这么做
        dic=dict()
        for x in strs:
            word=''.join(sorted(x))
            if dic.get(word) == None:
                dic[word]=[]
            dic[word].append(x) 
        res=[]
        for x in dic.values():
            res.append(x)
        return res
     
#########################调用函数###########################

sol=Solution()
strs=["eat", "tea", "tan", "ate", "nat", "bat"]
res=sol.groupAnagrams(strs) 
print(res) 