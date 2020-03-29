def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    import collections
    ans = collections.defaultdict(list)
    for s in strs:
        count = [0] * 26
        for c in s:
            count[ord(c) - ord('a')] += 1
        ans[tuple(count)].append(s)
    li = []
    for value in ans.values():
        li.append(value)
    return li
