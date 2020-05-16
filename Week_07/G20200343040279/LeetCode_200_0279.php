<?php

class Solution {
	function numIsland($grid) {
		$count = 0;
		if (empty($grid)) return $count;

		$row = count($grid);
		$col = count($grid[0]);

		for ($i = 0; $i < $row; $i++) {
			for ($j = 0; $j < $col; $j++) {
				if ($grid[$i][$j] == '1') {
					$this->dfs($grid, $i, $j, $row - 1, $col - 1);
					$count++;
				}
			}
		}
		return $count;
	}

	function dfs(&$grid, $i, $j, $row, $col) {
		if ($i < 0 || $j < 0 || $i > $row || $j > $col || $grid[$i][$j] != '1') return;
		$grid[$i][$j] = '*';
		$this->dfs($grid, $i - 1, $j, $row, $col);
		$this->dfs($grid, $i + 1, $j, $row, $col);
		$this->dfs($gird, $i, $j - 1, $row, $col);
		$this->dfs($gird, $i, $j + 1, $row, $col);
	}
}