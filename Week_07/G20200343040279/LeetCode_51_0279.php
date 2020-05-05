<?php
class Solution {
	function solveNQueens($n) {
		$board = array_fill(0, $n, str_repeat('.', $n));
		$res = [];
		$this->next($n, $board, 0, $res);
		return $res;
	}

	function next($n, $board, $row, &$res) {
		if ($row == $n) {
			$res[] = $board;
			return;
		}

		for ($j = 0; $j < $n; $j++) {
			if ($this->isValid($n, $board, $row, $j)) {
				$board[$row][$j] = 'Q';
				$this->next($n, $board, $row + 1, $res);
				$board[$row][$j] = '.';
			}
		}
	}

	function isValid($n, $board, $row, $col) {
		//检查列
		for ($i = 0; $i < $row; $i++) {
			if ($board[$i][$col] == 'Q') return false;
		}
		//检查左上角
		for ($i = $row - 1, $j = $col - 1; $i >= 0 && $j >= 0; $i--, $j--) {
			if ($board[$i][$j] == 'Q') return false;
		}
		//检查右上角
		for ($i = $row - 1, $j = $col + 1; $i >= 0&& $j < $n; $i--, $j++) {
			if ($board[$i][$j] == 'Q') return false;
		}
		return true;
	}
}