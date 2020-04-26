学习笔记

# 递归模版
````c#
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process(level, param);

    // drill down
    recur(level + 1, newParam);

    // restore current status
}
````

# 分治模版
````c#
public void divide_conquer(problem, param1, param2, ...) {
    // terminator
    if (problem == null) {
        // print result
        return;
    }

    // prepare data
    var data = prepare_data(problem);
    var subproblems = split_problem(problem, data);

    // conquer sub problems
    var subresult1 = divide_conquer(subproblems[0], p1, ...);
    var subresult2 = divide_conquer(subproblems[1], p1, ...);
    var subresult3 = divide_conquer(subproblems[2], p1, ...);

    // process and generate the final result
    var result = process_result(subresult1, subresult2, subresult3, ...);

    // revert the current level state
}
````
感触
- 人肉递归低效/很累
- 找到最近最简方法，将其拆解成可重复解决的问题
- 数学归纳法思维（抵制人肉递归的诱惑）
本质：寻找重复性->计算机指令集

# 动态规划
关键点
- 动态规划和递归/分治没有根本区别（关键看有无最优的子结构）
- **共性：找到重复子问题**
- 差异性：最优子结构，淘汰次优解
  
## 斐波拉契数列
````c#
// 用记忆降低复杂度
int fib(int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] == 0) {
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo); 
    }
    return memo[n];
}
// 自底向上解
int a[0] = 0, a[1] = 1;
for(int i = 2; i <=n; i++) {
    a[i] = a[i - 1] + a[i - 2];
}
````

关键点
- 最优子结构 opt[n]=best_of(opt[n - 1], opt[n - 2], ...)
- 存储中间状态 opt[i]
- 递推公式 状态转移方程/DP方程
Fib: opt[i] = opt[n - 1] + opt[n - 2]
二维路径： opt[i][j] = opt[i + 1][j] + opt[i][j + 1] (且判断opt[i][j]是否空地)

小结
- 打破自己的思维惯性，形成机器思维
- 理解复杂逻辑的关键
- 也是职业进阶的要点要领

思维要点
- 化繁为简，成为各种子问题
- 定义好状态空间
- 动态规划的方程

MIT - 5 easy steps to DP
- define subproblems    进行分治（把当前的复杂问题转换成一个简单的子问题）
- guess (part of solution)  猜递推方程
- relate subproblem solutions   合并子问题的解
- recurse & memoize or build DP fable bottom-up     递归和记忆化 或者 建立DP的状态表，自底向上进行递推
- solve original problem