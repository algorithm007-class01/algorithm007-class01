class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def backtrack(first=1, curr=[]):
            if len(curr) == k:
                output.append(curr[:])
            for i in range(first, n + 1):
                backtrack(i + 1, curr + [i])

        output = []
        backtrack()
        return output