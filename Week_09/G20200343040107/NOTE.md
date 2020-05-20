# 学习笔记
## 1. 动态规划复习
### 1.1 递归、分治、回朔、动态规划
- 递归： 函数自己调用自己
``` Java
public void recur(int level, int param) {
    // terminator 
    if (level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process(level, param);
    // drill down
    recur(level:level+1, newParam);
    // restore current status
}
```
- 分而治之(Divide&Conquer)
    - 拆解成可重复解决的问题
    - 数学归纳法思维
    - 本质：寻找重复性
    - 最优子结构、中途可以淘汰次优解
    ``` Python 
    def divide_conquer(problem, param1, param2, ...):
        # recursion terminator
        if proble is None:
            print_result
            return

        # prepare data 
        data = prepare_data(problem)
        subproblems = split_problem(proble, data)

        # conquer subproblems 
        subresult1 = self.divide_conquer(subproblems[0], p1, ...)
        subresult2 = self.divide_conquer(subproblems[1], p1, ...)    
        subresult3 = self.divide_conquer(subproblems[2], p1, ...)
        ...

        # process and generate the final result
        result = process_result(subresult1, subresult2, subresult3, ...)

        # revert the current level states

    ``` 
-  动态规划Dynamic Programming
    - 分治+最优子结构ååßßß
    - DP 顺推模板

    ``` 
        function DP():
            dp = [][]  # 二维情况
        
        for i = 0 .. M {
            for j = 0 .. N {
                dp[i][j] = _Function(dp[i][j]...)
            }
        }

        return dp[M][N]

    ``` 
- 常见问题
    - 爬楼梯
    - 不同路径
    - 打家劫舍
    - 最小路径和
    - 股票买卖
## 2. 字符串
### 2.1 字符串基础
- 字符串表示
- 遍历字符串
- 字符串比较
### 2.2 字符串相关算法
- 基础算法
    - 转换成小写
    - atoi
    - 最长公共子串
    - 回文串
    - ...
- 高级字符串算法
    - 最长子串、子序列
    - 字符串匹配算法
        - 暴力法(brute force)
        - Rabin-Karp算法
        - KMP算法
