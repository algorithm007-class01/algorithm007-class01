class Solution:
    def myAtoi(self, str: str) -> int:
        stack = [] 
        signed = False
        for c in str:
            if not stack:
                if c == "-":
                    stack.append(0)
                    signed = True 
                elif c =='+':
                    stack.append(0)
                elif c in string.digits:
                    stack.append(c)
                elif c != ' ':
                    break
                continue
            if c in string.digits:
                stack.append(c)
            else:
                break
        if not stack or stack == [0]:
            return 0
        res = 0
        for i in stack:
            num = int(i)
            if res < (2**31-num)/10:
                res = res * 10 + num
            else:
                return -2**31 if signed else 2**31-1
                break
        
        return -res if signed else res