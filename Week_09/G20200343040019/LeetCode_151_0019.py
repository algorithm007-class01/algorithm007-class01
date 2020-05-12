class Solution:
    def reverseWords(self, s: str) -> str:
        res = []
        for i in s.split(' '):
            if len(i)>0:
                res.append(i)

        return ' '.join(res[::-1])