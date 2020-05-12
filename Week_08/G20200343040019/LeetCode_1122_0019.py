class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        res = []

        c1 = collections.Counter(arr1)

        for n in arr2:
            res += [n]*c1[n]
            del c1[n]

        for k in sorted(c1.keys()):
            res += [k]*c1[k]
        
        return res