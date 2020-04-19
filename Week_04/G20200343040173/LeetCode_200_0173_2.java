import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * 广度优先搜索
 * 遍历二维数组，遇到 1 的时候计数一次，并使用广度优先搜索把周围的相连的“岛屿”放入 queue 中依次标记为“水“ 0，从而避免重复计数
 * 
 * 复杂度分析
    时间复杂度 : O(M * N)，其中 M 和 N 分别为行数和列数。
    空间复杂度 : O(min(M, N))，在最坏的情况下（全部为陆地），队列的大小可以达到 min(M，N)。
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int numIslands = 0;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    grid[row][col] = '0';
                    Queue<Integer> neighbors = new LinkedList<Integer>();
                    neighbors.add(row * colSize + col);

                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int r = id / colSize;
                        int c = id % colSize;

                        if (r - 1 >= 0 && grid[r-1][c] == '1') {
                            neighbors.add((r-1) * colSize + c);
                            grid[r-1][c] = '0';
                        }

                        if (r + 1 < rowSize && grid[r+1][c] == '1') {
                            neighbors.add((r+1) * colSize + c);
                            grid[r+1][c] = '0';
                        }

                        if (c - 1 >= 0 && grid[r][c-1] == '1') {
                            neighbors.add(r * colSize + c - 1);
                            grid[r][c-1] = '0';
                        }

                        if (c + 1 < colSize && grid[r][c+1] == '1') {
                            neighbors.add(r * colSize + c + 1);
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}