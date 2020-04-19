public class LeetCode_64_0201 {

    public int minPathSum(int[][] grid) {
        // 新建一个状态表
        int[][] states = new int[grid.length][grid[0].length];
        int sum = 0;
        // 初始化states的第一行数据
        for (int j = 0; j < states[0].length; ++j) {
            sum += grid[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        // 初始化states的第一列数据
        for (int i = 0; i < states.length; ++i) {
            sum += grid[i][0];
            states[i][0] = sum;
        }
        // 递推出每个位置的最小路径和
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                states[i][j] = grid[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        // 最后一个states的值，就是终点的最短路径和
        return states[states.length - 1][states[0].length - 1];
    }

}
