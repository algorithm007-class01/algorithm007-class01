/*
 * @lc app=leetcode.cn id=200 lang=csharp
 *
 * [200] 岛屿数量
 */

// @lc code=start
using System.Collections.Generic;

public class Solution {
    public int NumIslands (char[][] grid) {
        if (grid.Length == 0) return 0;
        int[] dx = {-1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
        Queue<KeyValuePair<int, int>> queue = new Queue<KeyValuePair<int, int>> ();
        int ans = 0, m = grid.Length, n = grid[0].Length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    queue.Enqueue (new KeyValuePair<int, int> (i, j));
                    while (queue.Count > 0) {
                        var kv = queue.Dequeue ();
                        for (int k = 0; k < 4; k++) {
                            int ti = kv.Key + dx[k], tj = kv.Value + dy[k];
                            if (ti < 0 || ti >= m || tj < 0 || tj >= n) continue;
                            if (grid[ti][tj] == '1') {
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