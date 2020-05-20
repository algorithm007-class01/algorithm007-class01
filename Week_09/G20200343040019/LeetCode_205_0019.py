class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dic = {}

        for i in range(len(s)):
            if s[i] not in dic:
                if t[i] in dic.values():
                    return False
                dic[s[i]] = t[i]
            else:
                if dic[s[i]] != t[i]:
                    return False
        
        return True