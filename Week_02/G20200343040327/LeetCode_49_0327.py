from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        tmp = defaultdict(list)
        for s in strs:
            tmp["".join(sorted(s))].append(s)
        return list(tmp.values())