<?php

class Solution {
	function solvesNquees($n) {
		$res = [];
		$board = array_fill(0, $n, str_repeat('.', $n));
		//echo json_encode($board) . PHP_EOL;
		$this->backtrack($n, $board, 0, $res);
		return $res;
	}

	function backtrack($n, $board, $row, &$res) {
		if ($row == $n) {
			$res[] = $board;
			return;
		}

		for ($i = 0; $i < $n; $i++) {
			if ($this->isValid($n, $board, $row, $i)) {
				$board[$row][$i] = 'Q';
				$this->backtrack($n, $board, $row + 1, $res);
				$board[$row][$i] = '.';
			}
		}
	}

	function isValid($n, $board, $row, $col) {
		for ($i = 0; $i < $row ; $i++)
			if ($board[$i][$col] == 'Q') return false;
		for ($i = $row - 1, $j = $col - 1; $i >= 0 && $j >= 0; $i--, $j--)
			if ($board[$i][$j] == 'Q') return false;
		for ($i = $row - 1, $j = $col + 1; $i >= 0 && $j < $n; $i--, $j++)
			if ($board[$i][$j] == 'Q') return false;
		return true;
	}
}

echo json_encode((new Solution())->solvesNquees(4)) . PHP_EOL;