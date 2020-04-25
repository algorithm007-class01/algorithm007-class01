class Solution(object):
    def isvalid(self, s):
        res = []
        model = {')':'('}
        for c in s:
            if c in model:
                top = res.pop() if res else 'q'
                if model[c] != top:
                    return False
            else:
                res.append(c)
        return not res


    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        num = 0
        for i in range(len(s)):
            for j in range(i+2 ,len(s)+1,2):
                if self.isvalid(s[i:j]):
                    num = max(num, j-i)

        return num