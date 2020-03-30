<?php

/**
 * 全排列 无重复值
 */
class Solution {
	function permute($nums) {
		$res = [];
		if (empty($nums)) return $res;
		$this->dfs($nums, 0, [], $res);
		return $res;
	}

	function dfs($nums, $depth, $list, &$res) {
		if ($depth == count($nums)) {
			$res[] = $list;
			return;
		}

		for ($i = 0; $i < count($nums); $i++) {
			if (in_array($nums[$i], $list)) continue;
			$list[] = $nums[$i];
			$this->dfs($nums, $depth + 1, $list, $res);
			array_pop($list);
		}
	}
}