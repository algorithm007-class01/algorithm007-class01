<?php

class Solution {
    
    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
        for ($i = count($grid) - 1; $i >= 0; $i--) {
            for ($j = count($grid[0]) - 1; $j >= 0; $j--) {
                if ($i == count($grid) - 1 && $j != count($grid[0]) - 1) {
                    $grid[$i][$j] += $grid[$i][$j + 1];
                } else if ($j == count($grid[0]) - 1 && $i != count($grid) - 1) {
                    $grid[$i][$j] += $grid[$i + 1][$j];
                } else if ($j != count($grid[0]) - 1 && $i != count($grid) - 1) {
                    $grid[$i][$j] += min($grid[$i + 1][$j], $grid[$i][$j + 1]);
                }
            }
        }
        return $grid[0][0];
    }
}