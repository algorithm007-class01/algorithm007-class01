class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        print(s,k)
        if not s:
            return ""
        if len(s) < k:
            print(s[::-1])
            return s[::-1]
        
        if k<=len(s)<=2*k:
            return s[k-1::-1]+s[k:]

        return self.reverseStr(s[:2*k], k)+ self.reverseStr(s[2*k:], k) 