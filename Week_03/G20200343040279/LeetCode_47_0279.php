<?php

/**
 * 全排列 有重复值
 */
class Solution {
	function permute($nums) {
		$res = [];
		if (empty($nums)) return $res;
		sort($nums);
		$used = [];
		$this->dfs($nums, 0, [], $res, $used);
		return $res;
	}

	function dfs($nums, $depth, $list, &$res, $used) {
		if ($depth == count($nums)) {
			$res[] = $list;
			return;
		} else {
			for ($i = 0; $i < count($nums); $i++) {
				if (isset($used[$i]) && $used[$i] == 1) continue;
				if ($i > 0 && $nums[$i] == $nums[$i - 1] && !$used[$i - 1]) continue;
				$used[$i] = 1;
				array_push($list, $nums[$i]);
				$this->dfs($nums, $i + 1, $list, $res);
				array_pop($list);
				$used[$i] = 0;
			}
		}
	}
}