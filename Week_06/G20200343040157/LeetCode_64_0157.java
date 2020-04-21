//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // f(a,b) = min(f(a+1,b),f(a,b+1)) + d(a,b)
    public int minPathSum(int[][] grid) {
        return m2(grid);
    }

    private int m2(int[][] grid) {
        if (grid == null || grid.length <= 0){
            return 0;
        }
        int width = grid[0].length;
        int height = grid.length;
        int[][] data = new int[height][width];
        data[height-1][width-1] = grid[height-1][width-1];
        if (width >= 2){
            for (int i = width-2; i >=0; i--) {
                data[height-1][i] = grid[height-1][i];
                data[height-1][i] = data[height-1][i] + data[height-1][i+1];
            }
        }
        if (height >=2 ){
            for (int j = height-2; j >=0 ; j--) {
                data[j][width-1] = grid[j][width-1];
                data[j][width-1] = data[j][width-1] + data[j+1][width-1];
            }
        }
        if (width >= 2 && height >=2){
            for (int j = height -2; j >= 0 ; j--) {
                for (int i = width -2; i >=0; i--) {
                    data[j][i] = grid[j][i];
                    data[j][i] = Math.min(data[j+1][i],data[j][i+1])+data[j][i];
                }
            }
        }
        return data[0][0];
    }

    private int m1(int[][] grid) {
        if (grid == null || grid.length <= 0){
            return 0;
        }
        int width = grid[0].length;
        int height = grid.length;
        int[][] data = new int[height][width];

        for (int j = height -1; j >= 0 ; j--) {
            for (int i = width -1; i >=0; i--) {
                data[j][i] = grid[j][i];
                int downMin = j+1 > height -1 ? -1 : data[j+1][i];
                int rightMin = i+1 > width -1 ? -1 : data[j][i+1];
                int min;
                if (downMin == -1 && rightMin == -1){
                    min = 0;
                }else if (downMin == -1){
                    min = rightMin;
                }else if (rightMin == -1){
                    min = downMin;
                }else {
                    min = Math.min(downMin,rightMin);
                }
                data[j][i] = min+data[j][i];
            }
        }
        return data[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
