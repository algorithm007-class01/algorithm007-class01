class Solution:
    def racecar(self, target: int) -> int:
        dp = [0, 1, 4]+[sys.maxsize for _ in range(target)]
      
        for i in range(3, target+1):
            n = i.bit_length()
            if i == 2**n-1:
                dp[i] = n
            else:
                for j in range(n-1):
                    dp[i] = min(dp[i], dp[i-2**(n-1)+2**j]+n+j+1)
                if 2**n-1-i<i:
                    dp[i] = min(dp[i], dp[2**n -1-i]+n+1)
        return dp[target]