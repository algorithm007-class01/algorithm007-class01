//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands_200 {

//    public static void main(String[] args) {
//        Solution solution = new NumberOfIslands_200().new Solution();
//        System.out.println(solution);
//    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 并查集
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }

        int waterCount = 0;
        UnionFind unionFind = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') {
                    waterCount++;
                    continue;
                }

                int index = i * n + j;
                if (i < m - 1 && grid[i + 1][j] == '1') {
                    unionFind.union(index, index + n);
                }
                if (j < n - 1 && grid[i][j + 1] == '1') {
                    unionFind.union(index, index + 1);
                }
            }
        }
        return unionFind.getCount() - waterCount;
    }

    // DFS
    public int numIslands1(char[][] grid) {
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands(grid, i, j, m, n);
                    num += 1;
                }
            }
        }
        return num;
    }
    private void numIslands(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        numIslands(grid, i - 1, j, m, n);
        numIslands(grid, i + 1, j, m, n);
        numIslands(grid, i, j - 1, m, n);
        numIslands(grid, i, j + 1, m, n);
    }
}

class UnionFind {

    /**
     * 集合的个数
     */
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化时，元素与元素之间尚未建立关系
            // 每个元素都在一个独立的集合中
            // 所以每个元素的父都是自己
            parent[i] = i;
        }
    }

    /**
     * 查找p的根，查找过程中，顺便优化p的根的查找路径
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != parent[p]) {
            // 如果p的父不是自己，那么将p的父修改为p的父的父。
            parent[p] = parent[parent[p]];
            // 向上查找，将p修改为p的父
            p = parent[p];
        }
        return p;
    }

    /**
     * 合并两个集合
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // 一个集合的所有子元素具有同一个根元素
        // 将两个集合的根元素修改为同一个元素，这两个集合就被合并了
        parent[rootQ] = rootP;

        count--;
    }

    public int getCount() {
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
  