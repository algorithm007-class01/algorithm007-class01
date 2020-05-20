# dp[i]：车子从0行驶到i的最短指令长度,起始速度是1,和target方向相同
# dp[0] = 0, dp[target]
# 因此每次转向，车速会变为1,每次车子转向了,车速变为1,如果此时速度方向也是朝向target，则和起始方向相同,可以使用dp
# 假设先用了A是k次,在k次加速后的位置是pos=2^k-1
# 如果pos<target: 要先A若干次再R再A再R AA..ARA..AR
# 在这两次R之间,假设A了q次,这时的位置在pos-(2^q-1)
# 第二次的R,speed=1,方向和target相同,这个就等于从0到target-(pos-(2^q-1)),这个步骤的最短指令长度为dp[target-(pos-(2^q-1))]
# 所以这个情况的全部指令集长度是k(A)+1(R)+q(A)+1(R)+dp[target-(pos-(2^q-1))]
# dp[i] = min(dp[i],k+1+q+1+dp[target-(pos-(2^q-1))])
# AAAAAA...A 最短指令长度为k,不使用转向 dp[i] = k
# AA..ARAA...A R过后需要达到的target的距离是pos-target,速度为1,等同于原来从正方向驶向target的指令集长度
# 总的指令长度是 k+1+dp[pos-target]
class Solution:
    def racecar(self, target: int) -> int:
        dp = [float('inf')] * (target+1)
        for i in range(target+1):
            k = 1
            pos = 1
            while pos < i:
                q = 0
                while ((1<<q)-1) < pos:
                    dp[i] = min(dp[i],k+q+2+dp[1-(pos-((1<<q-1))])
                    q += 1
                k += 1
                pos = (1<<k)-1
            if i == pos:
                dp[i] = k
            else:
                dp[i] = min(dp[i], k+1+dp[pos-i])
        return dp[target]