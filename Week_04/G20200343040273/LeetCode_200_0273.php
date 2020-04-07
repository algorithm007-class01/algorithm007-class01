/**
 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {

    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
        $count = 0;
        if(empty($grid)) return $count;

        $row = count($grid);
        $col = count($grid[0]);

        for ($i = 0; $i < $row; $i++) {
            for ($j = 0; $j < $col; $j++) {
                if ($grid[$i][$j] == 1) {
                    $this->dfs($grid, $i, $j, $row - 1, $col - 1);
                    $count++;
                }
            }
        }

        return $count;
    }

    // 深度优先遍历，把当前位置联通的1都变为*
    public function dfs(&$board, $i, $j, $row, $col)
    {
        if ($i < 0 || $i > $row || $j < 0 || $j > $col || $board[$i][$j] != '1') return;

        $board[$i][$j] = '*';
        $this->dfs($board, $i - 1, $j, $row, $col);
        $this->dfs($board, $i + 1, $j, $row, $col);
        $this->dfs($board, $i, $j - 1, $row, $col);
        $this->dfs($board, $i, $j + 1, $row, $col);
    }
}
