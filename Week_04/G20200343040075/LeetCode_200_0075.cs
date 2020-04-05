/*
 * @lc app=leetcode.cn id=200 lang=csharp
 *
 * [200] 岛屿数量
 */

// @lc code=start
using System.Collections.Generic;

public class Solution {
    /// <summary>
    /// BFS 把相邻的‘1’都转为‘0’,用来标记已访问过
    /// </summary>
    /// <param name="grid"></param>
    /// <returns></returns>
    public int NumIslands (char[][] grid) {
        if (grid.Length == 0) return 0;

        int[][] dirs = {
            new int[] { 0, -1 },
            new int[] { 0, 1 },
            new int[] {-1, 0 },
            new int[] { 1, 0 },
        };

        Queue<KeyValuePair<int, int>> queue = new Queue<KeyValuePair<int, int>> ();
        int ans = 0;
        int m = grid.Length, n = grid[0].Length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    queue.Enqueue (new KeyValuePair<int, int> (i, j));
                    while (queue.Count > 0) {
                        var pair = queue.Dequeue ();
                        int pi = pair.Key;
                        int pj = pair.Value;
                        foreach (int[] dir in dirs) {
                            int ti = pi + dir[0];
                            int tj = pj + dir[1];
                            if (ti >= 0 && ti < m && tj >= 0 && tj < n && grid[ti][tj] == '1') {
                                grid[ti][tj] = '0';
                                queue.Enqueue (new KeyValuePair<int, int> (ti, tj));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end