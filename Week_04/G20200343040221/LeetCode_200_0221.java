import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (47.31%)
 * Likes:    451
 * Dislikes: 0
 * Total Accepted:    74.1K
 * Total Submissions: 154.7K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    // 基于深度优先遍历
    // 递归将连城一片的岛屿消除，消除前将岛屿数量加1
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int num = 0;
        int x = grid.length;
        int y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                num++;
                eliminate(grid, i, j);
            }
        }
        return num;
    }

    private void eliminate(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        eliminate(grid, x - 1, y);
        eliminate(grid, x + 1, y);
        eliminate(grid, x, y - 1);
        eliminate(grid, x, y + 1);
    }

    public int numIslands1(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        Map<String, Set<String>> map = new HashMap<>(grid.length * grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if ('0' == row[j]) {
                    continue;
                }

                Set<String> set1 = null;
                if (j - 1 >= 0 && row[j - 1] == '1') {
                    set1 = map.get(i + "_" + (j - 1));
                }
                Set<String> set2 = null;
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    set2 = map.get((i - 1) + "_" + j);
                }

                String key = i + "_" + j;
                if (null != set1) {
                    if (null != set2) {
                        if (set1 != set2) {
                            set1.addAll(set2);
                            for (Iterator<String> iterator = set2.iterator(); iterator.hasNext();) {
                                map.put(iterator.next(), set1);
                            }
                        }
                    }
                    set1.add(key);
                    map.put(key, set1);
                } else {
                    if (null != set2) {
                        set2.add(key);
                        map.put(key, set2);
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(key);
                        map.put(key, set);
                    }
                }
            }
        }
        
        Set<Set<String>> islands = new HashSet<Set<String>>();
        islands.addAll(map.values());
        return islands.size();
    }
}
// @lc code=end

