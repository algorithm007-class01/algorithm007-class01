32.最长有效括号
1.动态规划  

class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        s=s.strip() #将字符串分开
        l=len(s)
        dp=[0]*l
        maxnumber=0
        for i in range(1,l):
            if s[i]==')':
                if s[i-1]=='(':
                    dp[i]=(dp[i-2] if i-2>=0 else 0)+2 
                elif s[i-dp[i-1]-1]=='(' and i-dp[i-1]>2:
                    dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
                elif s[i-dp[i-1]-1]=='(' and i-dp[i-1]>0:
                    dp[i]=dp[i-1]+2

            maxnumber=max(maxnumber,dp[i])
        return maxnumber     
2.利用栈的方法
class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        s=s.strip() #将字符串分开
        l=len(s)
        dp=[0]*l
        maxnumber=0
        queue=[]
        queue.append(-1)
        for i in range(0,l):
            if s[i]=='(':
                queue.append(i)
            else:
                queue.pop()
                if len(queue)==0:
                    queue.append(i)
                else:
                    maxnumber=max(maxnumber,i-queue[-1])

        return maxnumber
