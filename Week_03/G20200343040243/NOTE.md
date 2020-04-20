# 递归
## 递归思维要点

1. 不要人肉进行递归（最大误区）
2. 找最近最简方法，将其拆解成可重复解决的问题（最近最简重复子问题）
3. 数学归纳法思维

## 递归模板（写递归的时候首先写终止条件防止无限递归）

1. 终止条件（recursion terminator）
2. 处理当前层逻辑（process logic in current level）
3. 下探到下一层（drill down）
4. 清理当前层（reverse the current level status if needed）

## python代码模板
```
def recursion(level, param1, param2, ...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        return
    
    # process logic in current level
    process(level, data...)

    # drill down
    self.recursion(level + 1, p1, ...)

    # reverse the current level status if needed
```
## 补充

 * 递归语句之前的语句执行顺序是从递归最外层到递归最内层
 * 递归语句之后的语句执行顺序是从递归最内层到递归最外层



# 二叉树问题

1. 对左子树求解该问题
2. 对右子树求解该问题
3. 二叉树问题的结果，要么是左子树问题结果，要么是右子树问题结果，要么是左子树问题结果+右子树问题结果，要么是左子树问题结果和右子树问题结果比较取其一




# 分治

（比传统递归在drill down和reverse status中间多一步，将多个子问题的结果组合起来形成最终结果）

## python代码模板

···
def divide_conquer(problem, param1, param2, ...):
    # recursion terminator
    if problem is None:
        print_result
        return
    
    # prepare data, split big problem (process logic in current level)
    data = prepare_data(problem)
    subproblem = split_problem(problem, data)

    # conquer subproblems（drill down）
    subresult1 = self.divide_conquer(subproblem[0], p1, ...)
    subresult2 = self.divide_conquer(subproblem[1], p1, ...)
    subresult3 = self.divide_conquer(subproblem[2], p1, ...)
    ...

    # process and generate the final result (比普通递归多出来的一步，merge subresult)
    result = process_result(subresult1, subresult2, subresult3, ...)

    # reverse the current level status if needed 
···

# 回溯

本质还是递归

归去来兮


