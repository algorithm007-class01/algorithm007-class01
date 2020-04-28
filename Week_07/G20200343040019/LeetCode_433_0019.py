from collections import defaultdict
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if end not in bank or not start or not end or not bank:
            return -1
        dic = defaultdict(list)
        L = len(start)
        for g in bank:
            for i in range(L):
                dic[g[:i]+"*"+g[i+1:]].append(g)
        queue = [(start, 0)]
        visted = set()
        while queue:
            curr, res = queue.pop(0)
            if curr in visted:
                continue
            visted.add(curr)
            keys = [curr[:i]+"*"+curr[i+1:] for i in range(L)]

            for k in keys:
                pos = dic[k]
                if end in pos:
                    return res+1
                for p in pos:
                    if p not in visted:
                        queue.append((p, res+1))

        return -1