# -*- coding: utf-8 -*-


class Solution:

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        dir1,dir2={},{}
        for i in s:
            if i not in dir1:
                dir1[i]=1
            elif i in dir1:
                dir1[i]+=1
        for s in t:
            if s not in dir2:
                dir2[s]=1
            elif s in dir2:
                dir2[s]+=1
        if dir1==dir2:
            return True
        else:
            return False
