func generateParenthesis(n int) []string {
    // 使用new方法开辟内存返回内存地址
    res := new([]string)

    backtracking(n, n, "",  res)

    return *res
}

func backtracking(left, right int, tmp string, res *[]string) {
    /* 
        回溯跳出条件，
        并不需要判断左括号是否用完，因为右括号生成的条件 right > left ，
        所以右括号用完了就意味着左括号必定用完了
    */ 
    if right == 0 {
        *res = append(*res, tmp)
        return
    }

    // 生成左括号
    if left > 0 {
        backtracking(left - 1, right, tmp + "(", res)
    }

    // 括号成对存在，有左括号才会有右括号
    if right > left {
        backtracking(left, right - 1, tmp + ")", res)
    }
}

