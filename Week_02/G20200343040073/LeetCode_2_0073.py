class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}
        for s in strs:
            sort = str(sorted(s))
            if sort in d: d[sort].append(s)
            else: d[sort] = [s]
        return list(d.values())
