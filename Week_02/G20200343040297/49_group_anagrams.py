class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}

        for value in strs:
            k = "".join(sorted(value))
            if k in d:
                d[k].append(value)
            else:
                d[k] = [value]
        return list(d.values())