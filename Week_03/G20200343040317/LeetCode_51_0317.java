class Solution {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pia = new HashSet<>();
    private Set<Integer> na = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) {
            return new ArrayList<>();
        }
        dfs(0, n, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int row, int n, List<String> res, List<List<String>> ans) {
        // row 相当于层级，第几层
        // n 表示是几皇后场景
        // 存放计算过程中产生的结果
        // ans 汇总结果

        // 终结条件
        if (row == n) {
            // 这里不能直接add res 因为res里面存放的是整个中间计算过程的数据，必须要新建一个
            //  ans.add(res);
            ans.add(new ArrayList<>(res));
            return;
        }
        // 如下为处理过程
        // 尝试在row这一行的每一列放一下看看
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || pia.contains(row + i) || na.contains(row - i)) {
                // 在攻击范围内不能放置皇后
                continue;
            }
            // 尝试放入棋子在位置(row,i)
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            res.add(new String(chars));

            // 记录攻击范围
            cols.add(i);
            pia.add(row + i);
            na.add(row - i);

            // 进入下一层
            dfs(row + 1, n, res, ans);

            // 清理状态
            // res 的状态不能忘记，切记切记！！！
            res.remove(res.size() - 1);
            cols.remove(i);
            pia.remove(row + i);
            na.remove(row - i);
        }
    }
}