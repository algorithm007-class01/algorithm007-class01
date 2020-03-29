class Solution:
    def isValid(self, s: str) -> bool:
        ss = []
        for value in s:
            if value == '(':
                ss.append(')')
            elif value == '[':
                ss.append(']')
            elif value == '{':
                ss.append('}')
            else:
                if ss == []:
                    return False
                sss = ss.pop()
                if value != sss:
                    return False
        return ss == []