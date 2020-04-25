<?php

class Solution {
	function generateParenthesis($n) {
		$res = [];
		$this->backtracking(0, 0, $n, '', $res);
		return $res;
	}

	function backtracking($left, $right, $n, $s, &$res) {
		if ($left == $n && $right == $n) {
			$res[] = $s;
			return;
		}

		if ($left < $n)
			$this->backtracking($left + 1, $right, $n, $s . '(', $res);
		if ($right < $left)
			$this->backtracking($left, $right + 1, $n, $s . ')', $res);
	}
}