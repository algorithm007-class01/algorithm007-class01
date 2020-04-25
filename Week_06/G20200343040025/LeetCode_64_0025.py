//64.最小路径和
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        raws = len(grid)
        cols = len(grid[0])
        dp = [[0]*cols for _ in range(raws)]#构建二维dp数组
        dp[0][0] = grid[0][0]#初始化第一个值
        for raw in range(raws):
            for col in range(cols):
                if raw == 0 and col == 0:#当遇到第一个值时跳过,因为之前已经赋值了
                    continue
                if raw == 0:#当访问第一行的元素时,这时只需将第1行前面的元素相加即可
                    dp[raw][col] = dp[raw][col-1] + grid[raw][col]
                elif col == 0:#当访问第一列的元素时,这时只需将第1列前面的元素相加即可
                    dp[raw][col] = dp[raw-1][col] + grid[raw][col]
                else:#这是就根据转移方程计算
                    dp[raw][col] = min(dp[raw-1][col],dp[raw][col-1]) + grid[raw][col]
                    
        return dp[raws-1][cols-1] #返回最后一个值
