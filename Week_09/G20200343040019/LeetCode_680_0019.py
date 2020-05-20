class Solution:
    def validPalindrome(self, s: str) -> bool:

        def check(s):
            i, j = 0, len(s)-1
            while i<j:
                if s[i] == s[j]:
                    i+=1
                    j-=1
                else:
                    return False
            return True

        i, j = 0, len(s)-1

        while i<j:
            if s[i] == s[j]:
                i+=1
                j-=1
            else:
                #  remove i or remove j
                return check(s[i+1:j+1]) or check(s[i:j])

        return True       