<?php

/**
 *扫雷游戏
让我们一起来玩扫雷游戏！

给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。

现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

    如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
    如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
    如果在此次点击中，若无更多方块可被揭露，则返回面板。

 */
class Solution {


    public $dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,-1],[1,1]];
    public $row = 0;
    public $columns = 0;

    /**
     * 扫雷游戏DFS深度优先搜索
     * @param $board
     * @param $click
     */
    function updateBoard($board, $click) {

        $this->rows = count($board);
        $this->columns = count($board[0]);

        if ($board[$click[0]][$click[1]] == 'M') {
            $board[$click[0]][$click[1]] = 'X';
            return $board;
        }
        return $this->saoLeidfs($board, $click[0], $click[1]);
    }

    function saoLeidfs($board, $x, $y) {

        $num = $this->countor($board, $x, $y);
        if ($num == 0) {
            $board[$x][$y] = 'B';
        } else {
            $board[$x][$y] = strval($num);
            return $board;
        }

        foreach ($this->dirs as $dir) {
            $newRow = $dir[0] + $x;
            $newCol = $dir[1] + $y;
            if ($newRow >= 0 && $newRow < $this->rows && $newCol >= 0 && $newCol < $this->columns && $board[$newRow][$newCol] == 'E') {
                $board = $this->saoLeidfs($board, $newRow, $newCol);
            }
        }
        return $board;
    }

    function countor($board, $x, $y) {
        $num = 0;
        foreach ($this->dirs as $dir) {
            $newRow = $dir[0] + $x;
            $newCol = $dir[1] + $y;
            if ($newRow >= 0 && $newRow < $this->rows && $newCol >= 0 && $newCol < $this->columns && $board[$newRow][$newCol] == 'M') {
                $num++;
            }
        }
        return $num;
    }
}