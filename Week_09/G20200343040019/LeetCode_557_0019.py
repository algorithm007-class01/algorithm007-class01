class Solution:
    def reverseWords(self, s: str) -> str:
        res = []
        for w in s.split(" "):
            if len(w)>0:
                res.append(w[::-1])
            
        return " ".join(res)
        