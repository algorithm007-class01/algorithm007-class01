class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = {}

        for s in strs:
            k = ''.join(sorted(s))
            if k not in res:
                res[k] = [s] 
            else:
                res[k].append(s)
        
        return list(res.values())

